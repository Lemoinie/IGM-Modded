# Save‑Import Anti‑Cheat Plan

**Category:** `progression`

**Goal**: Prevent players from inflating the premium currency (gems) by editing the exported save file, while keeping the debugger free to edit saves during development.

---

## 1️⃣ High‑level Design
- Release builds will **encrypt** the gem value in the saved JSON (`gems_enc`).
- An optional **HMAC signature** (`gem_sig`) will protect the whole payload.
- A **runtime clamp** will also verify that the decoded gem amount never exceeds what the player could legitimately own (purchased packs + earned gems).
- Debug builds will skip all checks and continue to read/write the plain `gems` field for rapid testing.

---

## 2️⃣ Implementation Steps
1. **Gradle flag**
   - Add `buildConfigField("boolean", "ENFORCE_ANTI_CHEAT", "true")` to the `release` build type; set to `false` for `debug`.
2. **Security utility**
   - Create `storage/security/SaveSecurity.kt` with:
     - Per‑install AES‑GCM key from Android Keystore.
     - `encodeGems(Long): String` → Base64‑encoded ciphertext.
     - `decodeGems(JsonObject): Long` → Decrypt and return the gem count.
     - Optional `computeSignature(String): String` for HMAC.
3. **DataDeserializer**
   - Replace the raw `gems` read with:
     ```kotlin
     if (BuildConfig.ENFORCE_ANTI_CHEAT) {
         data.gems = SaveSecurity.decodeGems(rootObject)
     } else {
         data.gems = rootObject.get("gems").asLong
     }
     ```
4. **DataSerializer / Export flow**
   - Before writing the JSON, substitute `data.gems` with `SaveSecurity.encodeGems(data.gems)`.
   - Add a `gem_sig` field using `SaveSecurity.computeSignature(jsonString)` (optional).
5. **UI adjustments**
   - In `save_editor/index.html`, hide the raw gem input (`#field-gems`) for release builds.
   - Expose the plain value in the UI only after decryption for user feedback.
6. **Testing**
   - Unit tests for round‑trip encryption/decryption.
   - Integration tests: import a tampered save (plain gems) → expect clamped/zeroed gems on release.
   - Confirm debug builds load raw values unchanged.
7. **Documentation & Version bump**
   - Add a changelog entry (e.g. `1.3.15.14`).
   - Update `docs/` if needed.

---

## 3️⃣ Migration Path
| Step | Action |
|------|--------|
| 3.1 | Add Gradle flag. |
| 3.2 | Implement `SaveSecurity.kt`. |
| 3.3 | Modify `DataDeserializer.kt`. |
| 3.4 | Modify serialization/export code. |
| 3.5 | Adjust save‑editor UI. |
| 3.6 | Run full test suite. |
| 3.7 | Bump mod version and update changelog. |
| 3.8 | Release production APK. |

---

## 4️⃣ Validation Checklist
- [ ] `ENFORCE_ANTI_CHEAT` flag present and correctly set per build type.
- [ ] `SaveSecurity.encodeGems`/`decodeGems` round‑trip test passes.
- [ ] Release build clamps inflated gem values on import.
- [ ] Debug build loads plain gem values.
- [ ] UI no longer shows a writable gems field in release.
- [ ] All existing unit tests still pass.
- [ ] Changelog entry added.

---

**Owner:** *<Your Name>*
**Target release:** `1.3.15.14`
