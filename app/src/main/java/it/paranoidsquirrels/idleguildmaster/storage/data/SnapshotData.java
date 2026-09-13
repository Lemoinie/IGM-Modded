package it.paranoidsquirrels.idleguildmaster.storage.data;

/* JADX INFO: loaded from: classes3.dex */
public class SnapshotData {
    private byte[] data;
    private String description;

    public SnapshotData(String str, byte[] bArr) {
        this.description = str;
        this.data = bArr;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
