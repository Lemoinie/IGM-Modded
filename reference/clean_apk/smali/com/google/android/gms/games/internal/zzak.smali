.class public abstract Lcom/google/android/gms/games/internal/zzak;
.super Lcom/google/android/gms/internal/games_v2/zzb;
.source "com.google.android.gms:play-services-games-v2@@20.0.0"

# interfaces
.implements Lcom/google/android/gms/games/internal/zzal;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    const-string v0, "com.google.android.gms.games.internal.IGamesCallbacks"

    invoke-direct {p0, v0}, Lcom/google/android/gms/internal/games_v2/zzb;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final zza(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    const/16 p4, 0x1771

    if-eq p1, p4, :cond_7

    const/16 p4, 0x1772

    if-eq p1, p4, :cond_6

    const/16 p4, 0x2eeb

    if-eq p1, p4, :cond_5

    const/16 p4, 0x2eec

    if-eq p1, p4, :cond_4

    const/16 p4, 0x32c9

    if-eq p1, p4, :cond_3

    const/16 p4, 0x32ca

    if-eq p1, p4, :cond_2

    const/16 p4, 0x4a39

    if-eq p1, p4, :cond_1

    const/16 p4, 0x4a3a

    if-eq p1, p4, :cond_0

    packed-switch p1, :pswitch_data_0

    sparse-switch p1, :sswitch_data_0

    packed-switch p1, :pswitch_data_1

    packed-switch p1, :pswitch_data_2

    packed-switch p1, :pswitch_data_3

    packed-switch p1, :pswitch_data_4

    const/4 p1, 0x0

    return p1

    .line 74
    :pswitch_0
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    move-object v1, p1

    check-cast v1, Lcom/google/android/gms/common/data/DataHolder;

    .line 75
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 76
    sget-object p1, Lcom/google/android/gms/drive/Contents;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    move-object v3, p1

    check-cast v3, Lcom/google/android/gms/drive/Contents;

    sget-object p1, Lcom/google/android/gms/drive/Contents;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 77
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    move-object v4, p1

    check-cast v4, Lcom/google/android/gms/drive/Contents;

    sget-object p1, Lcom/google/android/gms/drive/Contents;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 78
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    move-object v5, p1

    check-cast v5, Lcom/google/android/gms/drive/Contents;

    .line 79
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    move-object v0, p0

    .line 80
    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/games/internal/zzak;->zzo(Lcom/google/android/gms/common/data/DataHolder;Ljava/lang/String;Lcom/google/android/gms/drive/Contents;Lcom/google/android/gms/drive/Contents;Lcom/google/android/gms/drive/Contents;)V

    goto/16 :goto_0

    .line 81
    :pswitch_1
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 82
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 83
    :pswitch_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 84
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    .line 85
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 86
    :pswitch_3
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 87
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 95
    :pswitch_4
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 96
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 97
    :pswitch_5
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 98
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 99
    :pswitch_6
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 100
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 101
    :pswitch_7
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 102
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 103
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzn(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 104
    :pswitch_8
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 105
    sget-object p4, Lcom/google/android/gms/drive/Contents;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p4}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p4

    check-cast p4, Lcom/google/android/gms/drive/Contents;

    .line 106
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 107
    invoke-virtual {p0, p1, p4}, Lcom/google/android/gms/games/internal/zzak;->zzq(Lcom/google/android/gms/common/data/DataHolder;Lcom/google/android/gms/drive/Contents;)V

    goto/16 :goto_0

    .line 114
    :pswitch_9
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 115
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 116
    :pswitch_a
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 117
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    .line 118
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 119
    :pswitch_b
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 120
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 121
    :pswitch_c
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 122
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 123
    :pswitch_d
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 124
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 125
    :pswitch_e
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 126
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 129
    :pswitch_f
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 130
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 131
    :pswitch_10
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 132
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 133
    :pswitch_11
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 134
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 135
    :pswitch_12
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 136
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 137
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 138
    :pswitch_13
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 139
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 140
    :pswitch_14
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 141
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 142
    :pswitch_15
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 143
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 144
    :pswitch_16
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 145
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 146
    :pswitch_17
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 147
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    .line 148
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 149
    :pswitch_18
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 150
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 151
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzh(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 1
    :sswitch_0
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 2
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 3
    :sswitch_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 4
    sget-object p1, Lcom/google/android/gms/games/internal/player/zze;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/games/internal/player/zze;

    .line 5
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 6
    :sswitch_2
    sget-object p1, Lcom/google/android/gms/common/api/Status;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/api/Status;

    .line 7
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 8
    :sswitch_3
    sget-object p1, Lcom/google/android/gms/common/api/Status;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/api/Status;

    .line 9
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object p4

    .line 10
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 11
    invoke-virtual {p0, p1, p4}, Lcom/google/android/gms/games/internal/zzak;->zzl(Lcom/google/android/gms/common/api/Status;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 12
    :sswitch_4
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 13
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 14
    :sswitch_5
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zze(Landroid/os/Parcel;)Z

    .line 15
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 16
    :sswitch_6
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 17
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 18
    :sswitch_7
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 19
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 20
    :sswitch_8
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 21
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 22
    :sswitch_9
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 23
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 24
    :sswitch_a
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 25
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 26
    :sswitch_b
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 27
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    .line 28
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 29
    :sswitch_c
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 30
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 31
    :sswitch_d
    sget-object p1, Lcom/google/android/gms/common/api/Status;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/api/Status;

    .line 32
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 33
    :sswitch_e
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 34
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 35
    :sswitch_f
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 36
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 37
    :sswitch_10
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 38
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 39
    :sswitch_11
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 40
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 41
    :sswitch_12
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 42
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 43
    :sswitch_13
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 44
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 45
    :sswitch_14
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 46
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 47
    :sswitch_15
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 48
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 49
    :sswitch_16
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 50
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 51
    :sswitch_17
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 52
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 53
    :sswitch_18
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 54
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 55
    :sswitch_19
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 56
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 63
    :sswitch_1a
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 64
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 65
    :sswitch_1b
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 66
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 67
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzi(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 68
    :sswitch_1c
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, p1}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Lcom/google/android/gms/common/data/DataHolder;

    .line 69
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 108
    :sswitch_1d
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 109
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 110
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzr(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 111
    :sswitch_1e
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    sget-object p1, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 112
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Landroid/os/Bundle;

    .line 113
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 127
    :sswitch_1f
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 128
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 156
    :sswitch_20
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 157
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 158
    :sswitch_21
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 159
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 160
    :sswitch_22
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 161
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 162
    :sswitch_23
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 163
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 164
    :sswitch_24
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 165
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 166
    :sswitch_25
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 167
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 168
    :sswitch_26
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 169
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 170
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zze(Landroid/os/Parcel;)Z

    .line 171
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 172
    :sswitch_27
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 173
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 174
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 175
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    :sswitch_28
    sget-object p1, Lcom/google/android/gms/games/multiplayer/realtime/zzb;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 176
    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/games/multiplayer/realtime/zzb;

    .line 177
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 178
    :sswitch_29
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 179
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 180
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 181
    :sswitch_2a
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 182
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 183
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 184
    :sswitch_2b
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 185
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 186
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 187
    :sswitch_2c
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 188
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 189
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 190
    :sswitch_2d
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 191
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 192
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 193
    :sswitch_2e
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 194
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    .line 195
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 196
    :sswitch_2f
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 197
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 198
    :sswitch_30
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 199
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 200
    :sswitch_31
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 201
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 202
    :sswitch_32
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 203
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 204
    :sswitch_33
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 205
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 206
    :sswitch_34
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 207
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 208
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 209
    :sswitch_35
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 210
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 211
    :sswitch_36
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 212
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 213
    :sswitch_37
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 214
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 215
    :sswitch_38
    invoke-virtual {p0}, Lcom/google/android/gms/games/internal/zzak;->zzm()V

    goto/16 :goto_0

    .line 216
    :pswitch_19
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 217
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 218
    :pswitch_1a
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 219
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 220
    :pswitch_1b
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 221
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto/16 :goto_0

    .line 222
    :pswitch_1c
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 223
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 224
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zze(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 225
    :pswitch_1d
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 226
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 227
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzj(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 228
    :pswitch_1e
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 229
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 230
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzk(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 231
    :pswitch_1f
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    sget-object p4, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 232
    invoke-static {p2, p4}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p4

    check-cast p4, Lcom/google/android/gms/common/data/DataHolder;

    .line 233
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 234
    invoke-virtual {p0, p1, p4}, Lcom/google/android/gms/games/internal/zzak;->zzf(Lcom/google/android/gms/common/data/DataHolder;Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 235
    :pswitch_20
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 236
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 237
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzg(Lcom/google/android/gms/common/data/DataHolder;)V

    goto/16 :goto_0

    .line 238
    :pswitch_21
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p1

    .line 239
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object p4

    .line 240
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 241
    invoke-virtual {p0, p1, p4}, Lcom/google/android/gms/games/internal/zzak;->zzb(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 242
    :pswitch_22
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 243
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 244
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzc(Lcom/google/android/gms/common/data/DataHolder;)V

    goto :goto_0

    .line 245
    :pswitch_23
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 246
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 247
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 57
    :cond_0
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 58
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zze(Landroid/os/Parcel;)Z

    .line 59
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 60
    :cond_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 61
    sget-object p1, Lcom/google/android/gms/games/video/VideoCapabilities;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/games/video/VideoCapabilities;

    .line 62
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 70
    :cond_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    .line 71
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 72
    :cond_3
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 73
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 88
    :cond_4
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result p1

    .line 89
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object p4

    .line 90
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 91
    invoke-virtual {p0, p1, p4}, Lcom/google/android/gms/games/internal/zzak;->zzp(ILjava/lang/String;)V

    goto :goto_0

    .line 92
    :cond_5
    sget-object p1, Lcom/google/android/gms/common/data/DataHolder;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-static {p2, p1}, Lcom/google/android/gms/internal/games_v2/zzc;->zza(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/data/DataHolder;

    .line 93
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 94
    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/zzak;->zzd(Lcom/google/android/gms/common/data/DataHolder;)V

    goto :goto_0

    .line 152
    :cond_6
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 153
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    goto :goto_0

    .line 154
    :cond_7
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    .line 155
    invoke-static {p2}, Lcom/google/android/gms/internal/games_v2/zzc;->zzb(Landroid/os/Parcel;)V

    .line 248
    :goto_0
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    const/4 p1, 0x1

    return p1

    :pswitch_data_0
    .packed-switch 0x1389
        :pswitch_23
        :pswitch_22
        :pswitch_21
        :pswitch_20
        :pswitch_1f
        :pswitch_1e
        :pswitch_1d
        :pswitch_1c
        :pswitch_1b
        :pswitch_1a
        :pswitch_19
    .end packed-switch

    :sswitch_data_0
    .sparse-switch
        0x1398 -> :sswitch_38
        0x1399 -> :sswitch_37
        0x139a -> :sswitch_36
        0x139b -> :sswitch_35
        0x139c -> :sswitch_34
        0x139d -> :sswitch_33
        0x139e -> :sswitch_32
        0x139f -> :sswitch_31
        0x13a0 -> :sswitch_30
        0x13a1 -> :sswitch_2f
        0x13a2 -> :sswitch_2e
        0x13a3 -> :sswitch_2d
        0x13a4 -> :sswitch_2c
        0x13a5 -> :sswitch_2b
        0x13a6 -> :sswitch_2a
        0x13a7 -> :sswitch_29
        0x13a8 -> :sswitch_28
        0x13a9 -> :sswitch_27
        0x13aa -> :sswitch_26
        0x13ab -> :sswitch_25
        0x13ac -> :sswitch_24
        0x13ad -> :sswitch_23
        0x13ae -> :sswitch_22
        0x13af -> :sswitch_21
        0x13b0 -> :sswitch_20
        0x2329 -> :sswitch_1f
        0x2af9 -> :sswitch_1e
        0x2ee1 -> :sswitch_1d
        0x36b1 -> :sswitch_1c
        0x3a99 -> :sswitch_1b
        0x426a -> :sswitch_1a
        0x4a40 -> :sswitch_19
        0x4a41 -> :sswitch_18
        0x4a42 -> :sswitch_17
        0x4e21 -> :sswitch_16
        0x4e22 -> :sswitch_15
        0x4e23 -> :sswitch_14
        0x4e24 -> :sswitch_13
        0x4e25 -> :sswitch_12
        0x4e26 -> :sswitch_11
        0x4e27 -> :sswitch_10
        0x4e28 -> :sswitch_f
        0x4e29 -> :sswitch_e
        0x4e2c -> :sswitch_d
        0x4e33 -> :sswitch_c
        0x4e34 -> :sswitch_b
        0x59d9 -> :sswitch_a
        0x59da -> :sswitch_9
        0x59db -> :sswitch_8
        0x59dc -> :sswitch_7
        0x59dd -> :sswitch_6
        0x5dc2 -> :sswitch_5
        0x61aa -> :sswitch_4
        0x61ab -> :sswitch_3
        0x61ac -> :sswitch_2
        0x61ad -> :sswitch_1
        0x61ae -> :sswitch_0
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x1f41
        :pswitch_18
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x2711
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x2ee4
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
    .end packed-switch

    :pswitch_data_4
    .packed-switch 0x2eee
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
