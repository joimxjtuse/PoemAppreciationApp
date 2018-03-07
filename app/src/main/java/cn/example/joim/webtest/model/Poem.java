package cn.example.joim.webtest.model;

import java.io.Serializable;

/**
 * Created by joim on 2018/3/3.
 */

public class Poem implements Serializable {

    private static final long serialVersionUID = 1137215340317715386L;

    private String mAuthor;

    private String mTitle;

    private String mBrief;

    private String mContent;

    private String mDynasty;

    private String mAlbumID;

    private String mEvaluate;

    private String mAnnotation;

    private String mTranslation;

    private String mAppreciateAnalyze;

    private String mClassify;

    private String mExcerpt;

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBrief() {
        return mBrief;
    }

    public void setmBrief(String mBrief) {
        this.mBrief = mBrief;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmDynasty() {
        return mDynasty;
    }

    public void setmDynasty(String mDynasty) {
        this.mDynasty = mDynasty;
    }

    public String getmAlbumID() {
        return mAlbumID;
    }

    public void setmAlbumID(String mAlbumID) {
        this.mAlbumID = mAlbumID;
    }

    public String getmEvaluate() {
        return mEvaluate;
    }

    public void setmEvaluate(String mEvaluate) {
        this.mEvaluate = mEvaluate;
    }

    public String getmAnnotation() {
        return mAnnotation;
    }

    public void setmAnnotation(String mAnnotation) {
        this.mAnnotation = mAnnotation;
    }

    public String getmTranslation() {
        return mTranslation;
    }

    public void setmTranslation(String mTranslation) {
        this.mTranslation = mTranslation;
    }

    public String getmAppreciateAnalyze() {
        return mAppreciateAnalyze;
    }

    public void setmAppreciateAnalyze(String mAppreciateAnalyze) {
        this.mAppreciateAnalyze = mAppreciateAnalyze;
    }

    public String getmClassify() {
        return mClassify;
    }

    public void setmClassify(String mClassify) {
        this.mClassify = mClassify;
    }

    public String getmExcerpt() {
        return mExcerpt;
    }

    public void setmExcerpt(String mExcerpt) {
        this.mExcerpt = mExcerpt;
    }
}
