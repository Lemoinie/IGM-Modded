.class public Landroidx/core/content/res/FontResourcesParserCompat;
.super Ljava/lang/Object;
.source "FontResourcesParserCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;,
        Landroidx/core/content/res/FontResourcesParserCompat$ProviderResourceEntry;,
        Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;,
        Landroidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry;,
        Landroidx/core/content/res/FontResourcesParserCompat$Api21Impl;,
        Landroidx/core/content/res/FontResourcesParserCompat$FetchStrategy;
    }
.end annotation


# static fields
.field private static final DEFAULT_TIMEOUT_MILLIS:I = 0x1f4

.field public static final FETCH_STRATEGY_ASYNC:I = 0x1

.field public static final FETCH_STRATEGY_BLOCKING:I = 0x0

.field public static final INFINITE_TIMEOUT_VALUE:I = -0x1

.field private static final ITALIC:I = 0x1

.field private static final NORMAL_WEIGHT:I = 0x190


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 373
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getType(Landroid/content/res/TypedArray;I)I
    .locals 0

    .line 270
    invoke-static {p0, p1}, Landroidx/core/content/res/FontResourcesParserCompat$Api21Impl;->getType(Landroid/content/res/TypedArray;I)I

    move-result p0

    return p0
.end method

.method public static parse(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 190
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    const/4 v2, 0x1

    if-eq v0, v2, :cond_0

    goto :goto_0

    :cond_0
    if-ne v0, v1, :cond_1

    .line 198
    invoke-static {p0, p1}, Landroidx/core/content/res/FontResourcesParserCompat;->readFamilies(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;

    move-result-object p0

    return-object p0

    .line 196
    :cond_1
    new-instance p0, Lorg/xmlpull/v1/XmlPullParserException;

    const-string p1, "No start tag found"

    invoke-direct {p0, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static readCerts(Landroid/content/res/Resources;I)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/res/Resources;",
            "I)",
            "Ljava/util/List<",
            "Ljava/util/List<",
            "[B>;>;"
        }
    .end annotation

    if-nez p1, :cond_0

    .line 289
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0

    .line 291
    :cond_0
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 293
    :try_start_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 294
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 312
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-object p0

    .line 297
    :cond_1
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    const/4 v2, 0x0

    .line 300
    invoke-static {v0, v2}, Landroidx/core/content/res/FontResourcesParserCompat;->getType(Landroid/content/res/TypedArray;I)I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_3

    move p1, v2

    .line 301
    :goto_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->length()I

    move-result v3

    if-ge p1, v3, :cond_4

    .line 302
    invoke-virtual {v0, p1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    if-eqz v3, :cond_2

    .line 304
    invoke-virtual {p0, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroidx/core/content/res/FontResourcesParserCompat;->toByteArrayList([Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 308
    :cond_3
    invoke-virtual {p0, p1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/content/res/FontResourcesParserCompat;->toByteArrayList([Ljava/lang/String;)Ljava/util/List;

    move-result-object p0

    invoke-interface {v1, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 312
    :cond_4
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-object v1

    :catchall_0
    move-exception p0

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 313
    throw p0
.end method

.method private static readFamilies(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x2

    const/4 v1, 0x0

    .line 203
    const-string v2, "font-family"

    invoke-interface {p0, v0, v1, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 204
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    .line 205
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 206
    invoke-static {p0, p1}, Landroidx/core/content/res/FontResourcesParserCompat;->readFamily(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;

    move-result-object p0

    return-object p0

    .line 208
    :cond_0
    invoke-static {p0}, Landroidx/core/content/res/FontResourcesParserCompat;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    return-object v1
.end method

.method private static readFamily(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FamilyResourceEntry;
    .locals 16
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    move-object/from16 v0, p1

    .line 215
    invoke-static/range {p0 .. p0}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v1

    .line 216
    sget-object v2, Landroidx/core/R$styleable;->FontFamily:[I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 217
    sget v2, Landroidx/core/R$styleable;->FontFamily_fontProviderAuthority:I

    invoke-virtual {v1, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 218
    sget v3, Landroidx/core/R$styleable;->FontFamily_fontProviderPackage:I

    invoke-virtual {v1, v3}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 219
    sget v4, Landroidx/core/R$styleable;->FontFamily_fontProviderQuery:I

    invoke-virtual {v1, v4}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 220
    sget v5, Landroidx/core/R$styleable;->FontFamily_fontProviderFallbackQuery:I

    invoke-virtual {v1, v5}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 221
    sget v6, Landroidx/core/R$styleable;->FontFamily_fontProviderCerts:I

    const/4 v7, 0x0

    invoke-virtual {v1, v6, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    .line 222
    sget v8, Landroidx/core/R$styleable;->FontFamily_fontProviderFetchStrategy:I

    const/4 v9, 0x1

    invoke-virtual {v1, v8, v9}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v13

    .line 224
    sget v8, Landroidx/core/R$styleable;->FontFamily_fontProviderFetchTimeout:I

    const/16 v9, 0x1f4

    invoke-virtual {v1, v8, v9}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v14

    .line 226
    sget v8, Landroidx/core/R$styleable;->FontFamily_fontProviderSystemFontFamily:I

    .line 227
    invoke-virtual {v1, v8}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v15

    .line 229
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    const/4 v1, 0x0

    const/4 v8, 0x3

    if-eqz v2, :cond_2

    if-eqz v3, :cond_2

    if-eqz v4, :cond_2

    .line 231
    :goto_0
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    if-eq v7, v8, :cond_0

    .line 232
    invoke-static/range {p0 .. p0}, Landroidx/core/content/res/FontResourcesParserCompat;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_0

    .line 234
    :cond_0
    invoke-static {v0, v6}, Landroidx/core/content/res/FontResourcesParserCompat;->readCerts(Landroid/content/res/Resources;I)Ljava/util/List;

    move-result-object v0

    if-eqz v5, :cond_1

    .line 237
    new-instance v1, Landroidx/core/provider/FontRequest;

    invoke-direct {v1, v2, v3, v5, v0}, Landroidx/core/provider/FontRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    :cond_1
    move-object v12, v1

    .line 241
    new-instance v1, Landroidx/core/content/res/FontResourcesParserCompat$ProviderResourceEntry;

    new-instance v11, Landroidx/core/provider/FontRequest;

    invoke-direct {v11, v2, v3, v4, v0}, Landroidx/core/provider/FontRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    move-object v10, v1

    invoke-direct/range {v10 .. v15}, Landroidx/core/content/res/FontResourcesParserCompat$ProviderResourceEntry;-><init>(Landroidx/core/provider/FontRequest;Landroidx/core/provider/FontRequest;IILjava/lang/String;)V

    return-object v1

    .line 249
    :cond_2
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 250
    :goto_1
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v3

    if-eq v3, v8, :cond_5

    .line 251
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v3

    const/4 v4, 0x2

    if-eq v3, v4, :cond_3

    goto :goto_1

    .line 252
    :cond_3
    invoke-interface/range {p0 .. p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 253
    const-string v4, "font"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 254
    invoke-static/range {p0 .. p1}, Landroidx/core/content/res/FontResourcesParserCompat;->readFont(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 256
    :cond_4
    invoke-static/range {p0 .. p0}, Landroidx/core/content/res/FontResourcesParserCompat;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_1

    .line 259
    :cond_5
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_6

    return-object v1

    .line 263
    :cond_6
    new-instance v0, Landroidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry;

    new-array v1, v7, [Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;

    invoke-interface {v2, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;

    invoke-direct {v0, v1}, Landroidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry;-><init>([Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;)V

    return-object v0
.end method

.method private static readFont(Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/Resources;)Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 327
    invoke-static {p0}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v0

    .line 328
    sget-object v1, Landroidx/core/R$styleable;->FontFamilyFont:[I

    invoke-virtual {p1, v0, v1}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object p1

    .line 329
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_fontWeight:I

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 330
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_fontWeight:I

    goto :goto_0

    .line 331
    :cond_0
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_android_fontWeight:I

    :goto_0
    const/16 v1, 0x190

    .line 332
    invoke-virtual {p1, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 333
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_fontStyle:I

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 334
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_fontStyle:I

    goto :goto_1

    .line 335
    :cond_1
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_android_fontStyle:I

    :goto_1
    const/4 v1, 0x0

    .line 336
    invoke-virtual {p1, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    const/4 v2, 0x1

    if-ne v2, v0, :cond_2

    move v5, v2

    goto :goto_2

    :cond_2
    move v5, v1

    .line 337
    :goto_2
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_ttcIndex:I

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 338
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_ttcIndex:I

    goto :goto_3

    .line 339
    :cond_3
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_android_ttcIndex:I

    .line 341
    :goto_3
    sget v2, Landroidx/core/R$styleable;->FontFamilyFont_fontVariationSettings:I

    invoke-virtual {p1, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 342
    sget v2, Landroidx/core/R$styleable;->FontFamilyFont_fontVariationSettings:I

    goto :goto_4

    .line 343
    :cond_4
    sget v2, Landroidx/core/R$styleable;->FontFamilyFont_android_fontVariationSettings:I

    .line 344
    :goto_4
    invoke-virtual {p1, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 345
    invoke-virtual {p1, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v7

    .line 346
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_font:I

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 347
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_font:I

    goto :goto_5

    .line 348
    :cond_5
    sget v0, Landroidx/core/R$styleable;->FontFamilyFont_android_font:I

    .line 349
    :goto_5
    invoke-virtual {p1, v0, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v8

    .line 350
    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 351
    invoke-virtual {p1}, Landroid/content/res/TypedArray;->recycle()V

    .line 352
    :goto_6
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result p1

    const/4 v0, 0x3

    if-eq p1, v0, :cond_6

    .line 353
    invoke-static {p0}, Landroidx/core/content/res/FontResourcesParserCompat;->skip(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_6

    .line 355
    :cond_6
    new-instance p0, Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;

    move-object v2, p0

    invoke-direct/range {v2 .. v8}, Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;-><init>(Ljava/lang/String;IZLjava/lang/String;II)V

    return-object p0
.end method

.method private static skip(Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x1

    :goto_0
    if-lez v0, :cond_2

    .line 362
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    const/4 v2, 0x2

    if-eq v1, v2, :cond_1

    const/4 v2, 0x3

    if-eq v1, v2, :cond_0

    goto :goto_0

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    return-void
.end method

.method private static toByteArrayList([Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "[B>;"
        }
    .end annotation

    .line 318
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 319
    array-length v1, p0

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v1, :cond_0

    aget-object v4, p0, v3

    .line 320
    invoke-static {v4, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v4

    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    return-object v0
.end method
