// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.widget;

import android.support.annotation.DrawableRes;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.support.annotation.Nullable;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.view.View;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.TintContextWrapper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v7.internal.widget.TintManager;
import android.support.v4.view.TintableBackgroundView;
import android.widget.AutoCompleteTextView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView
{
    private static final int[] TINT_ATTRS;
    private AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatTextHelper mTextHelper;
    private TintManager mTintManager;
    
    static {
        TINT_ATTRS = new int[] { 16843126 };
    }
    
    public AppCompatAutoCompleteTextView(final Context context) {
        this(context, null);
    }
    
    public AppCompatAutoCompleteTextView(final Context context, final AttributeSet set) {
        this(context, set, R.attr.autoCompleteTextViewStyle);
    }
    
    public AppCompatAutoCompleteTextView(final Context context, final AttributeSet set, final int n) {
        super(TintContextWrapper.wrap(context), set, n);
        final TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.getContext(), set, AppCompatAutoCompleteTextView.TINT_ATTRS, n, 0);
        this.mTintManager = obtainStyledAttributes.getTintManager();
        if (obtainStyledAttributes.hasValue(0)) {
            this.setDropDownBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        obtainStyledAttributes.recycle();
        (this.mBackgroundTintHelper = new AppCompatBackgroundHelper((View)this, this.mTintManager)).loadFromAttributes(set, n);
        (this.mTextHelper = new AppCompatTextHelper((TextView)this)).loadFromAttributes(set, n);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.applySupportBackgroundTint();
        }
    }
    
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.getSupportBackgroundTintList();
        }
        return null;
    }
    
    @Nullable
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
        }
        return null;
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundDrawable(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(@DrawableRes final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.onSetBackgroundResource(backgroundResource);
        }
    }
    
    public void setDropDownBackgroundResource(@DrawableRes final int dropDownBackgroundResource) {
        if (this.mTintManager != null) {
            this.setDropDownBackgroundDrawable(this.mTintManager.getDrawable(dropDownBackgroundResource));
            return;
        }
        super.setDropDownBackgroundResource(dropDownBackgroundResource);
    }
    
    public void setSupportBackgroundTintList(@Nullable final ColorStateList supportBackgroundTintList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintList(supportBackgroundTintList);
        }
    }
    
    public void setSupportBackgroundTintMode(@Nullable final PorterDuff$Mode supportBackgroundTintMode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.setSupportBackgroundTintMode(supportBackgroundTintMode);
        }
    }
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        if (this.mTextHelper != null) {
            this.mTextHelper.onSetTextAppearance(context, n);
        }
    }
}
