.class public final Landroidx/navigation/fragment/DialogFragmentNavigator;
.super Landroidx/navigation/Navigator;
.source "DialogFragmentNavigator.kt"


# annotations
.annotation runtime Landroidx/navigation/Navigator$Name;
    value = "dialog"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;,
        Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/navigation/Navigator<",
        "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nDialogFragmentNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogFragmentNavigator.kt\nandroidx/navigation/fragment/DialogFragmentNavigator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,235:1\n1741#2,3:236\n531#2,6:239\n*S KotlinDebug\n*F\n+ 1 DialogFragmentNavigator.kt\nandroidx/navigation/fragment/DialogFragmentNavigator\n*L\n50#1:236,3\n62#1:239,6\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u001f2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0008\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"
    }
    d2 = {
        "Landroidx/navigation/fragment/DialogFragmentNavigator;",
        "Landroidx/navigation/Navigator;",
        "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;",
        "context",
        "Landroid/content/Context;",
        "fragmentManager",
        "Landroidx/fragment/app/FragmentManager;",
        "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V",
        "observer",
        "Landroidx/lifecycle/LifecycleEventObserver;",
        "restoredTagsAwaitingAttach",
        "",
        "",
        "createDestination",
        "navigate",
        "",
        "entry",
        "Landroidx/navigation/NavBackStackEntry;",
        "entries",
        "",
        "navOptions",
        "Landroidx/navigation/NavOptions;",
        "navigatorExtras",
        "Landroidx/navigation/Navigator$Extras;",
        "onAttach",
        "state",
        "Landroidx/navigation/NavigatorState;",
        "popBackStack",
        "popUpTo",
        "savedState",
        "",
        "Companion",
        "Destination",
        "navigation-fragment_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x6,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final Companion:Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;

.field private static final TAG:Ljava/lang/String; = "DialogFragmentNavigator"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# instance fields
.field private final context:Landroid/content/Context;

.field private final fragmentManager:Landroidx/fragment/app/FragmentManager;

.field private final observer:Landroidx/lifecycle/LifecycleEventObserver;

.field private final restoredTagsAwaitingAttach:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$VQUVr_dYWOjGVr4ju096s2kI-3k(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V
    .locals 0

    invoke-static {p0, p1, p2}, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer$lambda-3(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public static synthetic $r8$lambda$oy64nBVrXn_2q6fQ0lG6hFLv40E(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;)V
    .locals 0

    invoke-static {p0, p1, p2}, Landroidx/navigation/fragment/DialogFragmentNavigator;->onAttach$lambda-5(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Landroidx/navigation/fragment/DialogFragmentNavigator;->Companion:Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "fragmentManager"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    invoke-direct {p0}, Landroidx/navigation/Navigator;-><init>()V

    .line 43
    iput-object p1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->context:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    .line 46
    new-instance p1, Ljava/util/LinkedHashSet;

    invoke-direct {p1}, Ljava/util/LinkedHashSet;-><init>()V

    check-cast p1, Ljava/util/Set;

    iput-object p1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->restoredTagsAwaitingAttach:Ljava/util/Set;

    .line 47
    new-instance p1, Landroidx/navigation/fragment/DialogFragmentNavigator$$ExternalSyntheticLambda0;

    invoke-direct {p1, p0}, Landroidx/navigation/fragment/DialogFragmentNavigator$$ExternalSyntheticLambda0;-><init>(Landroidx/navigation/fragment/DialogFragmentNavigator;)V

    iput-object p1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer:Landroidx/lifecycle/LifecycleEventObserver;

    return-void
.end method

.method private final navigate(Landroidx/navigation/NavBackStackEntry;)V
    .locals 4

    .line 125
    invoke-virtual {p1}, Landroidx/navigation/NavBackStackEntry;->getDestination()Landroidx/navigation/NavDestination;

    move-result-object v0

    check-cast v0, Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;

    .line 126
    invoke-virtual {v0}, Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;->getClassName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    .line 127
    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x2e

    if-ne v2, v3, :cond_0

    .line 128
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 130
    :cond_0
    iget-object v2, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    invoke-virtual {v2}, Landroidx/fragment/app/FragmentManager;->getFragmentFactory()Landroidx/fragment/app/FragmentFactory;

    move-result-object v2

    .line 131
    iget-object v3, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    .line 130
    invoke-virtual {v2, v3, v1}, Landroidx/fragment/app/FragmentFactory;->instantiate(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v1

    const-string v2, "fragmentManager.fragment\u2026ader, className\n        )"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const-class v2, Landroidx/fragment/app/DialogFragment;

    .line 133
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 136
    check-cast v1, Landroidx/fragment/app/DialogFragment;

    .line 137
    invoke-virtual {p1}, Landroidx/navigation/NavBackStackEntry;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroidx/fragment/app/DialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 138
    invoke-virtual {v1}, Landroidx/fragment/app/DialogFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v0

    iget-object v2, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer:Landroidx/lifecycle/LifecycleEventObserver;

    check-cast v2, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {v0, v2}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 139
    iget-object v0, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    invoke-virtual {p1}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroidx/fragment/app/DialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    .line 140
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->getState()Landroidx/navigation/NavigatorState;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/navigation/NavigatorState;->push(Landroidx/navigation/NavBackStackEntry;)V

    return-void

    .line 134
    :cond_1
    new-instance p1, Ljava/lang/StringBuilder;

    const-string v1, "Dialog destination "

    invoke-direct {p1, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;->getClassName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v0, " is not an instance of DialogFragment"

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 133
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static final observer$lambda-3(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V
    .locals 4

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "source"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "event"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 48
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;

    if-ne p2, v0, :cond_3

    .line 49
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 50
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->getState()Landroidx/navigation/NavigatorState;

    move-result-object p0

    invoke-virtual {p0}, Landroidx/navigation/NavigatorState;->getBackStack()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object p0

    invoke-interface {p0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Iterable;

    .line 236
    instance-of p2, p0, Ljava/util/Collection;

    if-eqz p2, :cond_0

    move-object p2, p0

    check-cast p2, Ljava/util/Collection;

    invoke-interface {p2}, Ljava/util/Collection;->isEmpty()Z

    move-result p2

    if-eqz p2, :cond_0

    goto :goto_0

    .line 237
    :cond_0
    invoke-interface {p0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_1
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_2

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/navigation/NavBackStackEntry;

    .line 50
    invoke-virtual {p2}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1}, Landroidx/fragment/app/DialogFragment;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_1

    goto/16 :goto_2

    .line 56
    :cond_2
    :goto_0
    invoke-virtual {p1}, Landroidx/fragment/app/DialogFragment;->dismiss()V

    goto/16 :goto_2

    .line 58
    :cond_3
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_STOP:Landroidx/lifecycle/Lifecycle$Event;

    if-ne p2, v0, :cond_8

    .line 59
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 60
    invoke-virtual {p1}, Landroidx/fragment/app/DialogFragment;->requireDialog()Landroid/app/Dialog;

    move-result-object p2

    invoke-virtual {p2}, Landroid/app/Dialog;->isShowing()Z

    move-result p2

    if-nez p2, :cond_8

    .line 61
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->getState()Landroidx/navigation/NavigatorState;

    move-result-object p2

    invoke-virtual {p2}, Landroidx/navigation/NavigatorState;->getBackStack()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object p2

    invoke-interface {p2}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/util/List;

    .line 239
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    invoke-interface {p2, v0}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v0

    .line 240
    :cond_4
    invoke-interface {v0}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 241
    invoke-interface {v0}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v1

    .line 242
    move-object v2, v1

    check-cast v2, Landroidx/navigation/NavBackStackEntry;

    .line 63
    invoke-virtual {v2}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Landroidx/fragment/app/DialogFragment;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    goto :goto_1

    :cond_5
    const/4 v1, 0x0

    .line 62
    :goto_1
    const-string v0, "Dialog "

    if-eqz v1, :cond_7

    check-cast v1, Landroidx/navigation/NavBackStackEntry;

    .line 68
    invoke-static {p2}, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p2, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_6

    .line 70
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 69
    const-string p2, "DialogFragmentNavigator"

    invoke-static {p2, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_6
    const/4 p1, 0x0

    .line 74
    invoke-virtual {p0, v1, p1}, Landroidx/navigation/fragment/DialogFragmentNavigator;->popBackStack(Landroidx/navigation/NavBackStackEntry;Z)V

    goto :goto_2

    .line 65
    :cond_7
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, " has already been popped off of the Navigation back stack"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 62
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_8
    :goto_2
    return-void
.end method

.method private static final onAttach$lambda-5(Landroidx/navigation/fragment/DialogFragmentNavigator;Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;)V
    .locals 1

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "<anonymous parameter 0>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "childFragment"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 152
    iget-object p1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->restoredTagsAwaitingAttach:Ljava/util/Set;

    check-cast p1, Ljava/util/Collection;

    invoke-virtual {p2}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Lkotlin/jvm/internal/TypeIntrinsics;->asMutableCollection(Ljava/lang/Object;)Ljava/util/Collection;

    move-result-object p1

    invoke-interface {p1, v0}, Ljava/util/Collection;->remove(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 154
    invoke-virtual {p2}, Landroidx/fragment/app/Fragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    iget-object p0, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer:Landroidx/lifecycle/LifecycleEventObserver;

    check-cast p0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, p0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public bridge synthetic createDestination()Landroidx/navigation/NavDestination;
    .locals 1

    .line 41
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->createDestination()Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;

    move-result-object v0

    check-cast v0, Landroidx/navigation/NavDestination;

    return-object v0
.end method

.method public createDestination()Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;
    .locals 2

    .line 105
    new-instance v0, Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;

    move-object v1, p0

    check-cast v1, Landroidx/navigation/Navigator;

    invoke-direct {v0, v1}, Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;-><init>(Landroidx/navigation/Navigator;)V

    return-object v0
.end method

.method public navigate(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/navigation/NavBackStackEntry;",
            ">;",
            "Landroidx/navigation/NavOptions;",
            "Landroidx/navigation/Navigator$Extras;",
            ")V"
        }
    .end annotation

    const-string p2, "entries"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 113
    iget-object p2, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    invoke-virtual {p2}, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z

    move-result p2

    if-eqz p2, :cond_0

    .line 114
    const-string p1, "DialogFragmentNavigator"

    const-string p2, "Ignoring navigate() call: FragmentManager has already saved its state"

    invoke-static {p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 117
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/navigation/NavBackStackEntry;

    .line 118
    invoke-direct {p0, p2}, Landroidx/navigation/fragment/DialogFragmentNavigator;->navigate(Landroidx/navigation/NavBackStackEntry;)V

    goto :goto_0

    :cond_1
    return-void
.end method

.method public onAttach(Landroidx/navigation/NavigatorState;)V
    .locals 3

    const-string v0, "state"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 144
    invoke-super {p0, p1}, Landroidx/navigation/Navigator;->onAttach(Landroidx/navigation/NavigatorState;)V

    .line 145
    invoke-virtual {p1}, Landroidx/navigation/NavigatorState;->getBackStack()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object p1

    invoke-interface {p1}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/navigation/NavBackStackEntry;

    .line 146
    iget-object v1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    .line 147
    invoke-virtual {v0}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v1

    check-cast v1, Landroidx/fragment/app/DialogFragment;

    if-eqz v1, :cond_0

    .line 148
    invoke-virtual {v1}, Landroidx/fragment/app/DialogFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer:Landroidx/lifecycle/LifecycleEventObserver;

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {v1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    goto :goto_0

    .line 149
    :cond_0
    iget-object v1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->restoredTagsAwaitingAttach:Ljava/util/Set;

    invoke-virtual {v0}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 151
    :cond_1
    iget-object p1, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    new-instance v0, Landroidx/navigation/fragment/DialogFragmentNavigator$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Landroidx/navigation/fragment/DialogFragmentNavigator$$ExternalSyntheticLambda1;-><init>(Landroidx/navigation/fragment/DialogFragmentNavigator;)V

    invoke-virtual {p1, v0}, Landroidx/fragment/app/FragmentManager;->addFragmentOnAttachListener(Landroidx/fragment/app/FragmentOnAttachListener;)V

    return-void
.end method

.method public popBackStack(Landroidx/navigation/NavBackStackEntry;Z)V
    .locals 4

    const-string v0, "popUpTo"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    invoke-virtual {v0}, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    const-string p1, "DialogFragmentNavigator"

    const-string p2, "Ignoring popBackStack() call: FragmentManager has already saved its state"

    .line 81
    invoke-static {p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 86
    :cond_0
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->getState()Landroidx/navigation/NavigatorState;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/navigation/NavigatorState;->getBackStack()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 89
    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 90
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    .line 88
    invoke-interface {v0, v1, v2}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v0

    .line 94
    check-cast v0, Ljava/lang/Iterable;

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/navigation/NavBackStackEntry;

    .line 95
    iget-object v2, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->fragmentManager:Landroidx/fragment/app/FragmentManager;

    invoke-virtual {v1}, Landroidx/navigation/NavBackStackEntry;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 97
    invoke-virtual {v1}, Landroidx/fragment/app/Fragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v2

    iget-object v3, p0, Landroidx/navigation/fragment/DialogFragmentNavigator;->observer:Landroidx/lifecycle/LifecycleEventObserver;

    check-cast v3, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {v2, v3}, Landroidx/lifecycle/Lifecycle;->removeObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 98
    check-cast v1, Landroidx/fragment/app/DialogFragment;

    invoke-virtual {v1}, Landroidx/fragment/app/DialogFragment;->dismiss()V

    goto :goto_0

    .line 101
    :cond_2
    invoke-virtual {p0}, Landroidx/navigation/fragment/DialogFragmentNavigator;->getState()Landroidx/navigation/NavigatorState;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroidx/navigation/NavigatorState;->pop(Landroidx/navigation/NavBackStackEntry;Z)V

    return-void
.end method
