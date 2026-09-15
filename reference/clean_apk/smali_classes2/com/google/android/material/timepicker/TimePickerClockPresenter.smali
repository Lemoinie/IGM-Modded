.class Lcom/google/android/material/timepicker/TimePickerClockPresenter;
.super Ljava/lang/Object;
.source "TimePickerClockPresenter.java"

# interfaces
.implements Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;
.implements Lcom/google/android/material/timepicker/TimePickerView$OnSelectionChange;
.implements Lcom/google/android/material/timepicker/TimePickerView$OnPeriodChangeListener;
.implements Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;
.implements Lcom/google/android/material/timepicker/TimePickerPresenter;


# static fields
.field private static final DEGREES_PER_HOUR:I = 0x1e

.field private static final DEGREES_PER_MINUTE:I = 0x6

.field private static final HOUR_CLOCK_24_VALUES:[Ljava/lang/String;

.field private static final HOUR_CLOCK_VALUES:[Ljava/lang/String;

.field private static final MINUTE_CLOCK_VALUES:[Ljava/lang/String;


# instance fields
.field private broadcasting:Z

.field private hourRotation:F

.field private minuteRotation:F

.field private final time:Lcom/google/android/material/timepicker/TimeModel;

.field private final timePickerView:Lcom/google/android/material/timepicker/TimePickerView;


# direct methods
.method static constructor <clinit>()V
    .locals 22

    const/16 v0, 0xc

    .line 48
    new-array v1, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "12"

    aput-object v3, v1, v2

    const-string v4, "1"

    const/4 v5, 0x1

    aput-object v4, v1, v5

    const/4 v4, 0x2

    const-string v6, "2"

    aput-object v6, v1, v4

    const-string v7, "3"

    const/4 v8, 0x3

    aput-object v7, v1, v8

    const/4 v7, 0x4

    const-string v9, "4"

    aput-object v9, v1, v7

    const/4 v10, 0x5

    const-string v11, "5"

    aput-object v11, v1, v10

    const/4 v12, 0x6

    const-string v13, "6"

    aput-object v13, v1, v12

    const-string v14, "7"

    const/4 v15, 0x7

    aput-object v14, v1, v15

    const/16 v14, 0x8

    const-string v16, "8"

    aput-object v16, v1, v14

    const-string v17, "9"

    const/16 v18, 0x9

    aput-object v17, v1, v18

    const/16 v17, 0xa

    const-string v19, "10"

    aput-object v19, v1, v17

    const-string v20, "11"

    const/16 v21, 0xb

    aput-object v20, v1, v21

    sput-object v1, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_VALUES:[Ljava/lang/String;

    .line 51
    new-array v1, v0, [Ljava/lang/String;

    const-string v20, "00"

    aput-object v20, v1, v2

    aput-object v6, v1, v5

    aput-object v9, v1, v4

    aput-object v13, v1, v8

    aput-object v16, v1, v7

    aput-object v19, v1, v10

    aput-object v3, v1, v12

    const-string v3, "14"

    aput-object v3, v1, v15

    const-string v3, "16"

    aput-object v3, v1, v14

    const-string v3, "18"

    aput-object v3, v1, v18

    const-string v3, "20"

    aput-object v3, v1, v17

    const-string v6, "22"

    aput-object v6, v1, v21

    sput-object v1, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_24_VALUES:[Ljava/lang/String;

    .line 54
    new-array v0, v0, [Ljava/lang/String;

    aput-object v20, v0, v2

    aput-object v11, v0, v5

    aput-object v19, v0, v4

    const-string v1, "15"

    aput-object v1, v0, v8

    aput-object v3, v0, v7

    const-string v1, "25"

    aput-object v1, v0, v10

    const-string v1, "30"

    aput-object v1, v0, v12

    const-string v1, "35"

    aput-object v1, v0, v15

    const-string v1, "40"

    aput-object v1, v0, v14

    const-string v1, "45"

    aput-object v1, v0, v18

    const-string v1, "50"

    aput-object v1, v0, v17

    const-string v1, "55"

    aput-object v1, v0, v21

    sput-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->MINUTE_CLOCK_VALUES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/timepicker/TimePickerView;Lcom/google/android/material/timepicker/TimeModel;)V
    .locals 1

    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 65
    iput-boolean v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->broadcasting:Z

    .line 68
    iput-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    .line 69
    iput-object p2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    .line 70
    invoke-virtual {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->initialize()V

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/material/timepicker/TimePickerClockPresenter;)Lcom/google/android/material/timepicker/TimeModel;
    .locals 0

    .line 41
    iget-object p0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    return-object p0
.end method

.method private getDegreesPerHour()I
    .locals 2

    .line 111
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->format:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    const/16 v0, 0xf

    goto :goto_0

    :cond_0
    const/16 v0, 0x1e

    :goto_0
    return v0
.end method

.method private getHourClockValues()[Ljava/lang/String;
    .locals 2

    .line 107
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->format:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    sget-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_24_VALUES:[Ljava/lang/String;

    goto :goto_0

    :cond_0
    sget-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_VALUES:[Ljava/lang/String;

    :goto_0
    return-object v0
.end method

.method private performHapticFeedback(II)V
    .locals 1

    .line 141
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    if-ne v0, p2, :cond_0

    iget-object p2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget p2, p2, Lcom/google/android/material/timepicker/TimeModel;->hour:I

    if-eq p2, p1, :cond_1

    .line 143
    :cond_0
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    const/4 p2, 0x4

    invoke-virtual {p1, p2}, Lcom/google/android/material/timepicker/TimePickerView;->performHapticFeedback(I)Z

    :cond_1
    return-void
.end method

.method private updateTime()V
    .locals 4

    .line 225
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v1, v1, Lcom/google/android/material/timepicker/TimeModel;->period:I

    iget-object v2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    invoke-virtual {v2}, Lcom/google/android/material/timepicker/TimeModel;->getHourForDisplay()I

    move-result v2

    iget-object v3, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v3, v3, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/material/timepicker/TimePickerView;->updateTime(III)V

    return-void
.end method

.method private updateValues()V
    .locals 2

    .line 230
    sget-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_VALUES:[Ljava/lang/String;

    const-string v1, "%d"

    invoke-direct {p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateValues([Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    sget-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->HOUR_CLOCK_24_VALUES:[Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateValues([Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    sget-object v0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->MINUTE_CLOCK_VALUES:[Ljava/lang/String;

    const-string v1, "%02d"

    invoke-direct {p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateValues([Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private updateValues([Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    const/4 v0, 0x0

    .line 236
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_0

    .line 237
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v1}, Lcom/google/android/material/timepicker/TimePickerView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    aget-object v2, p1, v0

    invoke-static {v1, v2, p2}, Lcom/google/android/material/timepicker/TimeModel;->formatText(Landroid/content/res/Resources;Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, p1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method public hide()V
    .locals 2

    .line 103
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/google/android/material/timepicker/TimePickerView;->setVisibility(I)V

    return-void
.end method

.method public initialize()V
    .locals 1

    .line 75
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->format:I

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v0}, Lcom/google/android/material/timepicker/TimePickerView;->showToggle()V

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v0, p0}, Lcom/google/android/material/timepicker/TimePickerView;->addOnRotateListener(Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;)V

    .line 80
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v0, p0}, Lcom/google/android/material/timepicker/TimePickerView;->setOnSelectionChangeListener(Lcom/google/android/material/timepicker/TimePickerView$OnSelectionChange;)V

    .line 81
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v0, p0}, Lcom/google/android/material/timepicker/TimePickerView;->setOnPeriodChangeListener(Lcom/google/android/material/timepicker/TimePickerView$OnPeriodChangeListener;)V

    .line 82
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v0, p0}, Lcom/google/android/material/timepicker/TimePickerView;->setOnActionUpListener(Lcom/google/android/material/timepicker/ClockHandView$OnActionUpListener;)V

    .line 83
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateValues()V

    .line 84
    invoke-virtual {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->invalidate()V

    return-void
.end method

.method public invalidate()V
    .locals 2

    .line 89
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    invoke-virtual {v0}, Lcom/google/android/material/timepicker/TimeModel;->getHourForDisplay()I

    move-result v0

    .line 90
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->getDegreesPerHour()I

    move-result v1

    mul-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->hourRotation:F

    .line 91
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    mul-int/lit8 v0, v0, 0x6

    int-to-float v0, v0

    iput v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->minuteRotation:F

    .line 92
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->selection:I

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->setSelection(IZ)V

    .line 93
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateTime()V

    return-void
.end method

.method public onActionUp(FZ)V
    .locals 6

    const/4 v0, 0x1

    .line 194
    iput-boolean v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->broadcasting:Z

    .line 195
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v1, v1, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    .line 196
    iget-object v2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v2, v2, Lcom/google/android/material/timepicker/TimeModel;->hour:I

    .line 197
    iget-object v3, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v3, v3, Lcom/google/android/material/timepicker/TimeModel;->selection:I

    const/16 v4, 0xa

    const/4 v5, 0x0

    if-ne v3, v4, :cond_1

    .line 200
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    iget p2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->hourRotation:F

    invoke-virtual {p1, p2, v5}, Lcom/google/android/material/timepicker/TimePickerView;->setHandRotation(FZ)V

    .line 203
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    .line 204
    invoke-virtual {p1}, Lcom/google/android/material/timepicker/TimePickerView;->getContext()Landroid/content/Context;

    move-result-object p1

    const-class p2, Landroid/view/accessibility/AccessibilityManager;

    invoke-static {p1, p2}, Landroidx/core/content/ContextCompat;->getSystemService(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/view/accessibility/AccessibilityManager;

    if-eqz p1, :cond_0

    .line 205
    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityManager;->isTouchExplorationEnabled()Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/16 p1, 0xc

    .line 207
    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->setSelection(IZ)V

    goto :goto_0

    .line 210
    :cond_1
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    if-nez p2, :cond_2

    add-int/lit8 p1, p1, 0xf

    .line 213
    div-int/lit8 p1, p1, 0x1e

    .line 214
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    mul-int/lit8 p1, p1, 0x5

    invoke-virtual {v0, p1}, Lcom/google/android/material/timepicker/TimeModel;->setMinute(I)V

    .line 215
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget p1, p1, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    mul-int/lit8 p1, p1, 0x6

    int-to-float p1, p1

    iput p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->minuteRotation:F

    .line 217
    :cond_2
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    iget v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->minuteRotation:F

    invoke-virtual {p1, v0, p2}, Lcom/google/android/material/timepicker/TimePickerView;->setHandRotation(FZ)V

    .line 219
    :goto_0
    iput-boolean v5, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->broadcasting:Z

    .line 220
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateTime()V

    .line 221
    invoke-direct {p0, v2, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->performHapticFeedback(II)V

    return-void
.end method

.method public onPeriodChange(I)V
    .locals 1

    .line 154
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    invoke-virtual {v0, p1}, Lcom/google/android/material/timepicker/TimeModel;->setPeriod(I)V

    return-void
.end method

.method public onRotate(FZ)V
    .locals 4

    .line 116
    iget-boolean v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->broadcasting:Z

    if-eqz v0, :cond_0

    return-void

    .line 120
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v0, v0, Lcom/google/android/material/timepicker/TimeModel;->hour:I

    .line 121
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v1, v1, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    .line 122
    invoke-static {p1}, Ljava/lang/Math;->round(F)I

    move-result p1

    .line 123
    iget-object v2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget v2, v2, Lcom/google/android/material/timepicker/TimeModel;->selection:I

    const/16 v3, 0xc

    if-ne v2, v3, :cond_1

    .line 125
    iget-object v2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    add-int/lit8 p1, p1, 0x3

    div-int/lit8 p1, p1, 0x6

    invoke-virtual {v2, p1}, Lcom/google/android/material/timepicker/TimeModel;->setMinute(I)V

    .line 126
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iget p1, p1, Lcom/google/android/material/timepicker/TimeModel;->minute:I

    mul-int/lit8 p1, p1, 0x6

    int-to-double v2, p1

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-float p1, v2

    iput p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->minuteRotation:F

    goto :goto_0

    .line 128
    :cond_1
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->getDegreesPerHour()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    .line 129
    iget-object v3, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    add-int/2addr p1, v2

    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->getDegreesPerHour()I

    move-result v2

    div-int/2addr p1, v2

    invoke-virtual {v3, p1}, Lcom/google/android/material/timepicker/TimeModel;->setHour(I)V

    .line 130
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    invoke-virtual {p1}, Lcom/google/android/material/timepicker/TimeModel;->getHourForDisplay()I

    move-result p1

    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->getDegreesPerHour()I

    move-result v2

    mul-int/2addr p1, v2

    int-to-float p1, p1

    iput p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->hourRotation:F

    :goto_0
    if-nez p2, :cond_2

    .line 135
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->updateTime()V

    .line 136
    invoke-direct {p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->performHapticFeedback(II)V

    :cond_2
    return-void
.end method

.method public onSelectionChanged(I)V
    .locals 1

    const/4 v0, 0x1

    .line 149
    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->setSelection(IZ)V

    return-void
.end method

.method setSelection(IZ)V
    .locals 4

    const/16 v0, 0xc

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 160
    :goto_0
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {v1, v0}, Lcom/google/android/material/timepicker/TimePickerView;->setAnimateOnTouchUp(Z)V

    .line 161
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->time:Lcom/google/android/material/timepicker/TimeModel;

    iput p1, v1, Lcom/google/android/material/timepicker/TimeModel;->selection:I

    .line 162
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    if-eqz v0, :cond_1

    .line 163
    sget-object v2, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->MINUTE_CLOCK_VALUES:[Ljava/lang/String;

    goto :goto_1

    :cond_1
    invoke-direct {p0}, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->getHourClockValues()[Ljava/lang/String;

    move-result-object v2

    :goto_1
    if-eqz v0, :cond_2

    .line 164
    sget v3, Lcom/google/android/material/R$string;->material_minute_suffix:I

    goto :goto_2

    :cond_2
    sget v3, Lcom/google/android/material/R$string;->material_hour_suffix:I

    .line 162
    :goto_2
    invoke-virtual {v1, v2, v3}, Lcom/google/android/material/timepicker/TimePickerView;->setValues([Ljava/lang/String;I)V

    .line 165
    iget-object v1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    if-eqz v0, :cond_3

    iget v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->minuteRotation:F

    goto :goto_3

    :cond_3
    iget v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->hourRotation:F

    :goto_3
    invoke-virtual {v1, v0, p2}, Lcom/google/android/material/timepicker/TimePickerView;->setHandRotation(FZ)V

    .line 166
    iget-object p2, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    invoke-virtual {p2, p1}, Lcom/google/android/material/timepicker/TimePickerView;->setActiveSelection(I)V

    .line 167
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    new-instance p2, Lcom/google/android/material/timepicker/TimePickerClockPresenter$1;

    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    .line 168
    invoke-virtual {v0}, Lcom/google/android/material/timepicker/TimePickerView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$string;->material_hour_selection:I

    invoke-direct {p2, p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter$1;-><init>(Lcom/google/android/material/timepicker/TimePickerClockPresenter;Landroid/content/Context;I)V

    .line 167
    invoke-virtual {p1, p2}, Lcom/google/android/material/timepicker/TimePickerView;->setMinuteHourDelegate(Landroidx/core/view/AccessibilityDelegateCompat;)V

    .line 179
    iget-object p1, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    new-instance p2, Lcom/google/android/material/timepicker/TimePickerClockPresenter$2;

    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    .line 180
    invoke-virtual {v0}, Lcom/google/android/material/timepicker/TimePickerView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$string;->material_minute_selection:I

    invoke-direct {p2, p0, v0, v1}, Lcom/google/android/material/timepicker/TimePickerClockPresenter$2;-><init>(Lcom/google/android/material/timepicker/TimePickerClockPresenter;Landroid/content/Context;I)V

    .line 179
    invoke-virtual {p1, p2}, Lcom/google/android/material/timepicker/TimePickerView;->setHourClickDelegate(Landroidx/core/view/AccessibilityDelegateCompat;)V

    return-void
.end method

.method public show()V
    .locals 2

    .line 98
    iget-object v0, p0, Lcom/google/android/material/timepicker/TimePickerClockPresenter;->timePickerView:Lcom/google/android/material/timepicker/TimePickerView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/material/timepicker/TimePickerView;->setVisibility(I)V

    return-void
.end method
