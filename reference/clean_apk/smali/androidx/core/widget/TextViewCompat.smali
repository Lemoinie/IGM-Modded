.class public final Landroidx/core/widget/TextViewCompat;
.super Ljava/lang/Object;
.source "TextViewCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/widget/TextViewCompat$Api26Impl;,
        Landroidx/core/widget/TextViewCompat$OreoCallback;,
        Landroidx/core/widget/TextViewCompat$Api28Impl;,
        Landroidx/core/widget/TextViewCompat$Api34Impl;,
        Landroidx/core/widget/TextViewCompat$Api23Impl;,
        Landroidx/core/widget/TextViewCompat$Api24Impl;,
        Landroidx/core/widget/TextViewCompat$AutoSizeTextType;
    }
.end annotation


# static fields
.field public static final AUTO_SIZE_TEXT_TYPE_NONE:I = 0x0

.field public static final AUTO_SIZE_TEXT_TYPE_UNIFORM:I = 0x1


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAutoSizeMaxTextSize(Landroid/widget/TextView;)I
    .locals 2

    .line 379
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 380
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api26Impl;->getAutoSizeMaxTextSize(Landroid/widget/TextView;)I

    move-result p0

    return p0

    .line 382
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 383
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0}, Landroidx/core/widget/AutoSizeableTextView;->getAutoSizeMaxTextSize()I

    move-result p0

    return p0

    :cond_1
    const/4 p0, -0x1

    return p0
.end method

.method public static getAutoSizeMinTextSize(Landroid/widget/TextView;)I
    .locals 2

    .line 362
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 363
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api26Impl;->getAutoSizeMinTextSize(Landroid/widget/TextView;)I

    move-result p0

    return p0

    .line 365
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 366
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0}, Landroidx/core/widget/AutoSizeableTextView;->getAutoSizeMinTextSize()I

    move-result p0

    return p0

    :cond_1
    const/4 p0, -0x1

    return p0
.end method

.method public static getAutoSizeStepGranularity(Landroid/widget/TextView;)I
    .locals 2

    .line 345
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 346
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api26Impl;->getAutoSizeStepGranularity(Landroid/widget/TextView;)I

    move-result p0

    return p0

    .line 348
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 349
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0}, Landroidx/core/widget/AutoSizeableTextView;->getAutoSizeStepGranularity()I

    move-result p0

    return p0

    :cond_1
    const/4 p0, -0x1

    return p0
.end method

.method public static getAutoSizeTextAvailableSizes(Landroid/widget/TextView;)[I
    .locals 2

    .line 396
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 397
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api26Impl;->getAutoSizeTextAvailableSizes(Landroid/widget/TextView;)[I

    move-result-object p0

    return-object p0

    .line 399
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 400
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0}, Landroidx/core/widget/AutoSizeableTextView;->getAutoSizeTextAvailableSizes()[I

    move-result-object p0

    return-object p0

    :cond_1
    const/4 p0, 0x0

    .line 402
    new-array p0, p0, [I

    return-object p0
.end method

.method public static getAutoSizeTextType(Landroid/widget/TextView;)I
    .locals 2

    .line 329
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 330
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api26Impl;->getAutoSizeTextType(Landroid/widget/TextView;)I

    move-result p0

    return p0

    .line 332
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 333
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0}, Landroidx/core/widget/AutoSizeableTextView;->getAutoSizeTextType()I

    move-result p0

    return p0

    :cond_1
    const/4 p0, 0x0

    return p0
.end method

.method public static getCompoundDrawableTintList(Landroid/widget/TextView;)Landroid/content/res/ColorStateList;
    .locals 0

    .line 978
    invoke-static {p0}, Landroidx/core/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 980
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api23Impl;->getCompoundDrawableTintList(Landroid/widget/TextView;)Landroid/content/res/ColorStateList;

    move-result-object p0

    return-object p0
.end method

.method public static getCompoundDrawableTintMode(Landroid/widget/TextView;)Landroid/graphics/PorterDuff$Mode;
    .locals 0

    .line 1013
    invoke-static {p0}, Landroidx/core/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1015
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api23Impl;->getCompoundDrawableTintMode(Landroid/widget/TextView;)Landroid/graphics/PorterDuff$Mode;

    move-result-object p0

    return-object p0
.end method

.method public static getCompoundDrawablesRelative(Landroid/widget/TextView;)[Landroid/graphics/drawable/Drawable;
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.getCompoundDrawablesRelative()"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 230
    invoke-virtual {p0}, Landroid/widget/TextView;->getCompoundDrawablesRelative()[Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static getFirstBaselineToTopHeight(Landroid/widget/TextView;)I
    .locals 1

    .line 709
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingTop()I

    move-result v0

    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object p0

    invoke-virtual {p0}, Landroid/text/TextPaint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object p0

    iget p0, p0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr v0, p0

    return v0
.end method

.method public static getLastBaselineToBottomHeight(Landroid/widget/TextView;)I
    .locals 1

    .line 719
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingBottom()I

    move-result v0

    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object p0

    invoke-virtual {p0}, Landroid/text/TextPaint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object p0

    iget p0, p0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v0, p0

    return v0
.end method

.method public static getMaxLines(Landroid/widget/TextView;)I
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.getMaxLines()"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 191
    invoke-virtual {p0}, Landroid/widget/TextView;->getMaxLines()I

    move-result p0

    return p0
.end method

.method public static getMinLines(Landroid/widget/TextView;)I
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.getMinLines()"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 202
    invoke-virtual {p0}, Landroid/widget/TextView;->getMinLines()I

    move-result p0

    return p0
.end method

.method private static getTextDirection(Landroid/text/TextDirectionHeuristic;)I
    .locals 2

    .line 932
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

    const/4 v1, 0x1

    if-ne p0, v0, :cond_0

    return v1

    .line 934
    :cond_0
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_1

    return v1

    .line 936
    :cond_1
    sget-object v0, Landroid/text/TextDirectionHeuristics;->ANYRTL_LTR:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_2

    const/4 p0, 0x2

    return p0

    .line 938
    :cond_2
    sget-object v0, Landroid/text/TextDirectionHeuristics;->LTR:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_3

    const/4 p0, 0x3

    return p0

    .line 940
    :cond_3
    sget-object v0, Landroid/text/TextDirectionHeuristics;->RTL:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_4

    const/4 p0, 0x4

    return p0

    .line 942
    :cond_4
    sget-object v0, Landroid/text/TextDirectionHeuristics;->LOCALE:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_5

    const/4 p0, 0x5

    return p0

    .line 944
    :cond_5
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_6

    const/4 p0, 0x6

    return p0

    .line 946
    :cond_6
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

    if-ne p0, v0, :cond_7

    const/4 p0, 0x7

    return p0

    :cond_7
    return v1
.end method

.method private static getTextDirectionHeuristic(Landroid/widget/TextView;)Landroid/text/TextDirectionHeuristic;
    .locals 4

    .line 876
    invoke-virtual {p0}, Landroid/widget/TextView;->getTransformationMethod()Landroid/text/method/TransformationMethod;

    move-result-object v0

    instance-of v0, v0, Landroid/text/method/PasswordTransformationMethod;

    if-eqz v0, :cond_0

    .line 878
    sget-object p0, Landroid/text/TextDirectionHeuristics;->LTR:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 881
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-lt v0, v1, :cond_3

    .line 882
    invoke-virtual {p0}, Landroid/widget/TextView;->getInputType()I

    move-result v0

    and-int/lit8 v0, v0, 0xf

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3

    .line 888
    invoke-virtual {p0}, Landroid/widget/TextView;->getTextLocale()Ljava/util/Locale;

    move-result-object p0

    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api24Impl;->getInstance(Ljava/util/Locale;)Landroid/icu/text/DecimalFormatSymbols;

    move-result-object p0

    .line 889
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api28Impl;->getDigitStrings(Landroid/icu/text/DecimalFormatSymbols;)[Ljava/lang/String;

    move-result-object p0

    aget-object p0, p0, v2

    .line 892
    invoke-virtual {p0, v2}, Ljava/lang/String;->codePointAt(I)I

    move-result p0

    .line 893
    invoke-static {p0}, Ljava/lang/Character;->getDirectionality(I)B

    move-result p0

    if-eq p0, v3, :cond_2

    const/4 v0, 0x2

    if-ne p0, v0, :cond_1

    goto :goto_0

    .line 898
    :cond_1
    sget-object p0, Landroid/text/TextDirectionHeuristics;->LTR:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 896
    :cond_2
    :goto_0
    sget-object p0, Landroid/text/TextDirectionHeuristics;->RTL:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 905
    :cond_3
    invoke-virtual {p0}, Landroid/widget/TextView;->getLayoutDirection()I

    move-result v0

    if-ne v0, v3, :cond_4

    move v2, v3

    .line 908
    :cond_4
    invoke-virtual {p0}, Landroid/widget/TextView;->getTextDirection()I

    move-result p0

    packed-switch p0, :pswitch_data_0

    if-eqz v2, :cond_5

    .line 911
    sget-object p0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

    goto :goto_1

    .line 924
    :pswitch_0
    sget-object p0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_RTL:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 922
    :pswitch_1
    sget-object p0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 920
    :pswitch_2
    sget-object p0, Landroid/text/TextDirectionHeuristics;->LOCALE:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 918
    :pswitch_3
    sget-object p0, Landroid/text/TextDirectionHeuristics;->RTL:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 916
    :pswitch_4
    sget-object p0, Landroid/text/TextDirectionHeuristics;->LTR:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 914
    :pswitch_5
    sget-object p0, Landroid/text/TextDirectionHeuristics;->ANYRTL_LTR:Landroid/text/TextDirectionHeuristic;

    return-object p0

    .line 912
    :cond_5
    sget-object p0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    :goto_1
    return-object p0

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static getTextMetricsParams(Landroid/widget/TextView;)Landroidx/core/text/PrecomputedTextCompat$Params;
    .locals 3

    .line 789
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    .line 790
    new-instance v0, Landroidx/core/text/PrecomputedTextCompat$Params;

    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api28Impl;->getTextMetricsParams(Landroid/widget/TextView;)Landroid/text/PrecomputedText$Params;

    move-result-object p0

    invoke-direct {v0, p0}, Landroidx/core/text/PrecomputedTextCompat$Params;-><init>(Landroid/text/PrecomputedText$Params;)V

    return-object v0

    .line 792
    :cond_0
    new-instance v0, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;

    new-instance v1, Landroid/text/TextPaint;

    .line 793
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    invoke-direct {v0, v1}, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;-><init>(Landroid/text/TextPaint;)V

    .line 795
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api23Impl;->getBreakStrategy(Landroid/widget/TextView;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;->setBreakStrategy(I)Landroidx/core/text/PrecomputedTextCompat$Params$Builder;

    .line 796
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat$Api23Impl;->getHyphenationFrequency(Landroid/widget/TextView;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;->setHyphenationFrequency(I)Landroidx/core/text/PrecomputedTextCompat$Params$Builder;

    .line 798
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat;->getTextDirectionHeuristic(Landroid/widget/TextView;)Landroid/text/TextDirectionHeuristic;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;->setTextDirection(Landroid/text/TextDirectionHeuristic;)Landroidx/core/text/PrecomputedTextCompat$Params$Builder;

    .line 799
    invoke-virtual {v0}, Landroidx/core/text/PrecomputedTextCompat$Params$Builder;->build()Landroidx/core/text/PrecomputedTextCompat$Params;

    move-result-object p0

    return-object p0
.end method

.method public static setAutoSizeTextTypeUniformWithConfiguration(Landroid/widget/TextView;IIII)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .line 283
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 284
    invoke-static {p0, p1, p2, p3, p4}, Landroidx/core/widget/TextViewCompat$Api26Impl;->setAutoSizeTextTypeUniformWithConfiguration(Landroid/widget/TextView;IIII)V

    goto :goto_0

    .line 286
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 287
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0, p1, p2, p3, p4}, Landroidx/core/widget/AutoSizeableTextView;->setAutoSizeTextTypeUniformWithConfiguration(IIII)V

    :cond_1
    :goto_0
    return-void
.end method

.method public static setAutoSizeTextTypeUniformWithPresetSizes(Landroid/widget/TextView;[II)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .line 310
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 311
    invoke-static {p0, p1, p2}, Landroidx/core/widget/TextViewCompat$Api26Impl;->setAutoSizeTextTypeUniformWithPresetSizes(Landroid/widget/TextView;[II)V

    goto :goto_0

    .line 312
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 313
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0, p1, p2}, Landroidx/core/widget/AutoSizeableTextView;->setAutoSizeTextTypeUniformWithPresetSizes([II)V

    :cond_1
    :goto_0
    return-void
.end method

.method public static setAutoSizeTextTypeWithDefaults(Landroid/widget/TextView;I)V
    .locals 2

    .line 247
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-lt v0, v1, :cond_0

    .line 248
    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat$Api26Impl;->setAutoSizeTextTypeWithDefaults(Landroid/widget/TextView;I)V

    goto :goto_0

    .line 249
    :cond_0
    instance-of v0, p0, Landroidx/core/widget/AutoSizeableTextView;

    if-eqz v0, :cond_1

    .line 250
    check-cast p0, Landroidx/core/widget/AutoSizeableTextView;

    invoke-interface {p0, p1}, Landroidx/core/widget/AutoSizeableTextView;->setAutoSizeTextTypeWithDefaults(I)V

    :cond_1
    :goto_0
    return-void
.end method

.method public static setCompoundDrawableTintList(Landroid/widget/TextView;Landroid/content/res/ColorStateList;)V
    .locals 0

    .line 962
    invoke-static {p0}, Landroidx/core/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 964
    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat$Api23Impl;->setCompoundDrawableTintList(Landroid/widget/TextView;Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public static setCompoundDrawableTintMode(Landroid/widget/TextView;Landroid/graphics/PorterDuff$Mode;)V
    .locals 0

    .line 996
    invoke-static {p0}, Landroidx/core/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 998
    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat$Api23Impl;->setCompoundDrawableTintMode(Landroid/widget/TextView;Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public static setCompoundDrawablesRelative(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.setCompoundDrawablesRelative(start, top, end, bottom)"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 125
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/widget/TextView;->setCompoundDrawablesRelative(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public static setCompoundDrawablesRelativeWithIntrinsicBounds(Landroid/widget/TextView;IIII)V
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 180
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(IIII)V

    return-void
.end method

.method public static setCompoundDrawablesRelativeWithIntrinsicBounds(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 153
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/widget/TextView;->setCompoundDrawablesRelativeWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public static setCustomSelectionActionModeCallback(Landroid/widget/TextView;Landroid/view/ActionMode$Callback;)V
    .locals 0
    .annotation runtime Landroidx/annotation/ReplaceWith;
        expression = "textView.setCustomSelectionActionModeCallback(callback)"
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 433
    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat;->wrapCustomSelectionActionModeCallback(Landroid/widget/TextView;Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode$Callback;

    move-result-object p1

    .line 432
    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V

    return-void
.end method

.method public static setFirstBaselineToTopHeight(Landroid/widget/TextView;I)V
    .locals 3

    .line 639
    invoke-static {p1}, Landroidx/core/util/Preconditions;->checkArgumentNonnegative(I)I

    .line 640
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    .line 641
    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat$Api28Impl;->setFirstBaselineToTopHeight(Landroid/widget/TextView;I)V

    return-void

    .line 645
    :cond_0
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-virtual {v0}, Landroid/text/TextPaint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    .line 647
    invoke-virtual {p0}, Landroid/widget/TextView;->getIncludeFontPadding()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 648
    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    goto :goto_0

    .line 650
    :cond_1
    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    .line 656
    :goto_0
    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v1

    if-le p1, v1, :cond_2

    add-int/2addr p1, v0

    .line 658
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result v0

    .line 659
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingRight()I

    move-result v1

    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingBottom()I

    move-result v2

    .line 658
    invoke-virtual {p0, v0, p1, v1, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    :cond_2
    return-void
.end method

.method public static setLastBaselineToBottomHeight(Landroid/widget/TextView;I)V
    .locals 3

    .line 682
    invoke-static {p1}, Landroidx/core/util/Preconditions;->checkArgumentNonnegative(I)I

    .line 684
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-virtual {v0}, Landroid/text/TextPaint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    .line 686
    invoke-virtual {p0}, Landroid/widget/TextView;->getIncludeFontPadding()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 687
    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    goto :goto_0

    .line 689
    :cond_0
    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 695
    :goto_0
    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v1

    if-le p1, v1, :cond_1

    sub-int/2addr p1, v0

    .line 697
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingTop()I

    move-result v1

    .line 698
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaddingRight()I

    move-result v2

    .line 697
    invoke-virtual {p0, v0, v1, v2, p1}, Landroid/widget/TextView;->setPadding(IIII)V

    :cond_1
    return-void
.end method

.method public static setLineHeight(Landroid/widget/TextView;I)V
    .locals 2

    .line 738
    invoke-static {p1}, Landroidx/core/util/Preconditions;->checkArgumentNonnegative(I)I

    .line 740
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->getFontMetricsInt(Landroid/graphics/Paint$FontMetricsInt;)I

    move-result v0

    if-eq p1, v0, :cond_0

    sub-int/2addr p1, v0

    int-to-float p1, p1

    const/high16 v0, 0x3f800000    # 1.0f

    .line 744
    invoke-virtual {p0, p1, v0}, Landroid/widget/TextView;->setLineSpacing(FF)V

    :cond_0
    return-void
.end method

.method public static setLineHeight(Landroid/widget/TextView;IF)V
    .locals 2

    .line 768
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-lt v0, v1, :cond_0

    .line 769
    invoke-static {p0, p1, p2}, Landroidx/core/widget/TextViewCompat$Api34Impl;->setLineHeight(Landroid/widget/TextView;IF)V

    goto :goto_0

    .line 774
    :cond_0
    invoke-virtual {p0}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 771
    invoke-static {p1, p2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result p1

    .line 776
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView;I)V

    :goto_0
    return-void
.end method

.method public static setPrecomputedText(Landroid/widget/TextView;Landroidx/core/text/PrecomputedTextCompat;)V
    .locals 2

    .line 854
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    if-lt v0, v1, :cond_0

    .line 857
    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat;->getPrecomputedText()Landroid/text/PrecomputedText;

    move-result-object p1

    invoke-static {p1}, Landroidx/core/widget/TextViewCompat$Api28Impl;->castToCharSequence(Landroid/text/PrecomputedText;)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 859
    :cond_0
    invoke-static {p0}, Landroidx/core/widget/TextViewCompat;->getTextMetricsParams(Landroid/widget/TextView;)Landroidx/core/text/PrecomputedTextCompat$Params;

    move-result-object v0

    .line 860
    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat;->getParams()Landroidx/core/text/PrecomputedTextCompat$Params;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/core/text/PrecomputedTextCompat$Params;->equalsWithoutTextDirection(Landroidx/core/text/PrecomputedTextCompat$Params;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 863
    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :goto_0
    return-void

    .line 861
    :cond_1
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "Given text can not be applied to TextView."

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static setTextAppearance(Landroid/widget/TextView;I)V
    .locals 0

    .line 216
    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setTextAppearance(I)V

    return-void
.end method

.method public static setTextMetricsParams(Landroid/widget/TextView;Landroidx/core/text/PrecomputedTextCompat$Params;)V
    .locals 2

    .line 814
    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat$Params;->getTextDirection()Landroid/text/TextDirectionHeuristic;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/widget/TextViewCompat;->getTextDirection(Landroid/text/TextDirectionHeuristic;)I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTextDirection(I)V

    .line 832
    invoke-virtual {p0}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat$Params;->getTextPaint()Landroid/text/TextPaint;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->set(Landroid/text/TextPaint;)V

    .line 836
    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat$Params;->getBreakStrategy()I

    move-result v0

    invoke-static {p0, v0}, Landroidx/core/widget/TextViewCompat$Api23Impl;->setBreakStrategy(Landroid/widget/TextView;I)V

    .line 837
    invoke-virtual {p1}, Landroidx/core/text/PrecomputedTextCompat$Params;->getHyphenationFrequency()I

    move-result p1

    invoke-static {p0, p1}, Landroidx/core/widget/TextViewCompat$Api23Impl;->setHyphenationFrequency(Landroid/widget/TextView;I)V

    return-void
.end method

.method public static unwrapCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode$Callback;
    .locals 2

    .line 465
    instance-of v0, p0, Landroidx/core/widget/TextViewCompat$OreoCallback;

    if-eqz v0, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_0

    .line 466
    check-cast p0, Landroidx/core/widget/TextViewCompat$OreoCallback;

    invoke-virtual {p0}, Landroidx/core/widget/TextViewCompat$OreoCallback;->getWrappedCallback()Landroid/view/ActionMode$Callback;

    move-result-object p0

    :cond_0
    return-object p0
.end method

.method public static wrapCustomSelectionActionModeCallback(Landroid/widget/TextView;Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode$Callback;
    .locals 2

    .line 444
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_1

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1b

    if-gt v0, v1, :cond_1

    instance-of v0, p1, Landroidx/core/widget/TextViewCompat$OreoCallback;

    if-nez v0, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    .line 454
    :cond_0
    new-instance v0, Landroidx/core/widget/TextViewCompat$OreoCallback;

    invoke-direct {v0, p1, p0}, Landroidx/core/widget/TextViewCompat$OreoCallback;-><init>(Landroid/view/ActionMode$Callback;Landroid/widget/TextView;)V

    return-object v0

    :cond_1
    :goto_0
    return-object p1
.end method
