package com.lemoinie.idleguildcompanion;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;

public class CompanionFileProvider extends ContentProvider {
    public static final String AUTHORITY = "com.lemoinie.idleguildcompanion.fileprovider";

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return "text/plain";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        File file = new File(getContext().getCacheDir(), "shared_save.txt");
        if (file.exists()) {
            return ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        }
        throw new FileNotFoundException("File not found: " + uri.getPath());
    }
}
