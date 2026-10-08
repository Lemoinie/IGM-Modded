#!/usr/bin/env python3
"""Export game sprites referenced by the wiki extractor into
igmplus_wiki/public/images/ so VitePress can serve them.

Reads sprites.json (written by extract_game_data.py), copies the matching
bitmap files from app/src/main/res/drawable*/ (XML vector drawables and
drawable-watch are skipped), and writes sprites_manifest.json back into the
data directory.

Stdlib-only. See docs/scripts.md.

Usage:
  python scripts/igmplus_wiki/export_sprites.py [--repo ROOT]
      [--data DIR] [--out DIR]
"""

from __future__ import annotations

import argparse
import json
import shutil
import sys
from pathlib import Path

SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_REPO = SCRIPT_DIR.parents[1]
RES_BASE = Path("app/src/main/res")

BITMAP_EXTS = (".png", ".webp", ".jpg", ".jpeg", ".gif")
# search priority: density dir first (usually the real art), then plain drawable
DIR_PRIORITY = ("drawable-hdpi", "drawable", "drawable-xhdpi", "drawable-xxhdpi")
EXCLUDED_DIRS = ("drawable-watch",)


def find_resource(res_root: Path, name: str) -> tuple[Path | None, str | None]:
    """Return (path, reason). reason set when not found or not a bitmap."""
    skipped_xml = None
    for dirname in DIR_PRIORITY:
        d = res_root / dirname
        if not d.is_dir():
            continue
        for ext in BITMAP_EXTS:
            candidate = d / f"{name}{ext}"
            if candidate.is_file():
                return candidate, None
        xml = d / f"{name}.xml"
        if xml.is_file() and skipped_xml is None:
            skipped_xml = "xml_vector"
    # any other drawable dir (except excluded), lower priority
    for d in sorted(res_root.glob("drawable*")):
        if not d.is_dir() or d.name in EXCLUDED_DIRS or d.name in DIR_PRIORITY:
            continue
        for ext in BITMAP_EXTS:
            candidate = d / f"{name}{ext}"
            if candidate.is_file():
                return candidate, None
        if (d / f"{name}.xml").is_file() and skipped_xml is None:
            skipped_xml = "xml_vector"
    return None, skipped_xml or "not_found"


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--repo", type=Path, default=DEFAULT_REPO)
    ap.add_argument("--data", type=Path, default=None,
                    help="extractor data dir (default <repo>/igmplus_wiki/data)")
    ap.add_argument("--out", type=Path, default=None,
                    help="sprite output dir (default <repo>/igmplus_wiki/public/images)")
    args = ap.parse_args(argv)
    repo = args.repo.resolve()
    data_dir = (args.data or repo / "igmplus_wiki" / "data").resolve()
    out_dir = (args.out or repo / "igmplus_wiki" / "public" / "images").resolve()
    res_root = repo / RES_BASE

    sprites_file = data_dir / "sprites.json"
    if not sprites_file.is_file():
        print(f"error: {sprites_file} not found; run extract_game_data.py first",
              file=sys.stderr)
        return 1

    sprites: dict[str, list[str]] = json.loads(
        sprites_file.read_text(encoding="utf-8")
    )
    out_dir.mkdir(parents=True, exist_ok=True)

    manifest: dict[str, dict] = {}
    skipped: dict[str, str] = {}
    copied = 0
    for name in sorted(sprites):
        src, reason = find_resource(res_root, name)
        if src is None:
            skipped[name] = reason or "not_found"
            continue
        dest = out_dir / src.name
        if not dest.exists() or dest.stat().st_size != src.stat().st_size:
            shutil.copy2(src, dest)
        copied += 1
        manifest[name] = {
            "file": src.name,
            "bytes": src.stat().st_size,
            "source": str(src.relative_to(repo)).replace("\\", "/"),
            "usages": sprites[name],
        }

    data_dir.mkdir(parents=True, exist_ok=True)
    manifest_path = data_dir / "sprites_manifest.json"
    manifest_path.write_text(
        json.dumps(
            {"exported": manifest, "skipped": skipped},
            indent=2,
            ensure_ascii=False,
        )
        + "\n",
        encoding="utf-8",
    )
    print(
        f"exported {copied}/{len(sprites)} sprites to {out_dir} "
        f"(skipped {len(skipped)}), manifest: {manifest_path.name}"
    )
    if skipped:
        reasons: dict[str, int] = {}
        for r in skipped.values():
            reasons[r] = reasons.get(r, 0) + 1
        print(f"  skip reasons: {reasons}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
