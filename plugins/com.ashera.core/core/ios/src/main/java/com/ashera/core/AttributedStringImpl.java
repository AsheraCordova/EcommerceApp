package com.ashera.core;

import java.util.Map;

/*-[
#include <UIKit/UIKit.h>
#import <CoreText/CoreText.h>
]-*/
public class AttributedStringImpl implements com.ashera.attributedtext.AttributedString {
	private Object attributedString;
	private IFragment fragment;
	private Map<String, Float> textSizes = new java.util.HashMap<>();
	private  String text;
	public AttributedStringImpl(IFragment fragment, String text) {
		this.fragment = fragment;
		this.text = text;
		init(text);
	}
	@Override
	public Object get() {
		return attributedString;
	}

	@Override
	public void init(int start, int end) {
		
	}
	
	public native void init(String text) /*-[
		attributedString_ = [[NSMutableAttributedString alloc]
		        initWithString:text];
	]-*/;

	@Override
	public native void applyUnderLine(int start, int end)/*-[
		[((NSMutableAttributedString*)attributedString_) addAttributes: @{NSUnderlineStyleAttributeName:[NSNumber numberWithInteger:NSUnderlineStyleSingle]} range:NSMakeRange(start,end-start)];
	]-*/;

	@Override
	public native void applyColor(Object color, int start, int end)/*-[
		[((NSMutableAttributedString*)attributedString_) addAttributes: @{NSForegroundColorAttributeName:(UIColor*)color} range:NSMakeRange(start,end-start)];
	]-*/;

	@Override
	public native void applyStrikeThrough(int start, int end)/*-[
		[((NSMutableAttributedString*)attributedString_) addAttributes: @{NSStrikethroughStyleAttributeName:[NSNumber numberWithInteger:NSUnderlineStyleSingle]} range:NSMakeRange(start,end-start)];
	]-*/;

	@Override
	public void applyFont(Object typeFace, float textSize, int style,
			int start, int end) {
		Map<String, com.ashera.model.FontDescriptor> fontDescriptors = (Map<String, com.ashera.model.FontDescriptor>) typeFace;
		
		if (fontDescriptors != null) {
	        String weight = "400";
	        if ((style & 0x1) != 0) {
	            weight = "700";
	        }
	        String fontStyle = "normal";
	        if ((style & 0x2) != 0) {
	            fontStyle = "italic";
	        }
	        com.ashera.model.FontDescriptor fontDescriptor = fontDescriptors.get(fontStyle + "_" + weight);
			
			if (textSize == 0) {
				textSize = getSystemFontSize();
			} else {
				textSize = fragment.getRootActivity().getScaleFactor() * textSize;
			}
			
			String key = start + "_" + end;
			textSizes.put(key, textSize);
			Object font = getFont(fontDescriptor.getName(), textSize);
			
			applyFont(font, textSize, (style & 1) != 0, (style & 2) != 0, start, end);
		}
	}
	
	public native Object applyFont(Object font, float textSize, boolean isBold, boolean isItalics, int start, int end)/*-[
		if (isBold) {
			UIFontDescriptor* fontD = [((UIFont*) font).fontDescriptor
	                            fontDescriptorWithSymbolicTraits:UIFontDescriptorTraitBold
	                            | ((UIFont*) font).fontDescriptor.symbolicTraits];
	        if (fontD != nil) {
				font = [UIFont fontWithDescriptor:fontD size:0];
			}
		}
		if (isItalics) {
			UIFontDescriptor* fontD = [((UIFont*) font).fontDescriptor
	                            fontDescriptorWithSymbolicTraits:UIFontDescriptorTraitItalic
	                            | ((UIFont*) font).fontDescriptor.symbolicTraits];
	        if (fontD != nil) {                    
				font = [UIFont fontWithDescriptor:fontD size:0];
			}
		}
		[((NSMutableAttributedString*)attributedString_) addAttributes: @{NSFontAttributeName:(UIFont*) font} range:NSMakeRange(start,end-start)];
		return font;
	]-*/;
	

	@Override
	public void applyVerticalAlign(String verticalAlign, int start, int end) {
		String key = start + "_" + end;
		Float textSize = textSizes.get(key);
		if (textSize == null || textSize == 0) {
			textSize = getSystemFontSize();
		}
		if (verticalAlign.equals("super")) {
			applySuperscript(textSize, start, end);
		} else if (verticalAlign.equals("sub")) {
			applySubscript(textSize, start, end);
		}
	}
	
	public native void applySuperscript(float textSize, int start, int end) /*-[
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSBaselineOffsetAttributeName
	              value:@(textSize/2) range:NSMakeRange(start, end - start)];
	]-*/;

	public native void applySubscript(float textSize, int start, int end) /*-[
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSBaselineOffsetAttributeName
	              value:@(-textSize/2) range:NSMakeRange(start, end - start)];
	]-*/;
	
	private native float getSystemFontSize() /*-[	
		return [UIFont labelFontSize];
	]-*/;
	
	public native Object getFont(String typeFace, float textSize)/*-[		
		UIFont* font = nil;
		if (typeFace == nil) {
			font = [UIFont systemFontOfSize:textSize];
		} else {
			font = [UIFont fontWithName:typeFace size:textSize];
		}
		return font;
	]-*/;

	@Override
	public native void applyLineHeight(float height, int start, int end) /*-[
		NSMutableParagraphStyle *style = [[NSMutableParagraphStyle alloc] init];
		[style setLineSpacing:height];
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSParagraphStyleAttributeName
		                  value:style
		                  range:NSMakeRange(start, end - start)];
	]-*/;

	@Override
	public void applyTextAlign(String value, int start, int end) {
		if (value.equals("center")) {
			applyTextAlignCenter(start, end);
		} else if (value.equals("right")) {
			applyTextAlignRight(start, end);
		} else {
			applyTextAlignLeft(start, end);
		}
	}
	
	public native void applyTextAlignCenter(int start, int end) /*-[
		NSMutableParagraphStyle *paragraphStyle = [[NSMutableParagraphStyle alloc] init];
		[paragraphStyle setAlignment:NSTextAlignmentCenter];
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSParagraphStyleAttributeName
	                  value:paragraphStyle range:NSMakeRange(start, end - start)];
	]-*/;
	
	public native void applyTextAlignLeft(int start, int end) /*-[
		NSMutableParagraphStyle *paragraphStyle = [[NSMutableParagraphStyle alloc] init];
		[paragraphStyle setAlignment:NSTextAlignmentLeft];
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSParagraphStyleAttributeName
	                  value:paragraphStyle range:NSMakeRange(start, end - start)];
	]-*/;
	public native void applyTextAlignRight(int start, int end) /*-[
		NSMutableParagraphStyle *paragraphStyle = [[NSMutableParagraphStyle alloc] init];
		[paragraphStyle setAlignment:NSTextAlignmentRight];
		[((NSMutableAttributedString*)attributedString_)  addAttribute:NSParagraphStyleAttributeName
	                  value:paragraphStyle range:NSMakeRange(start, end - start)];
	]-*/;

	@Override
	public native void applyBackgroundColor(Object color, int start, int end) /*-[
		[((NSMutableAttributedString*)attributedString_) addAttributes: @{NSBackgroundColorAttributeName:(UIColor*)color} range:NSMakeRange(start,end-start)];
	]-*/;

	@Override
	public native void applyUrl(String href, Object color, int start, int end)/*-[
		[((NSMutableAttributedString*)attributedString_) addAttribute: NSLinkAttributeName value: href range: NSMakeRange(start, end - start)];
	]-*/;

	@Override
	public void applyImg(Object image, int start, int end) {
		Object drawable = ((r.android.graphics.drawable.Drawable) image).getDrawable();
		nativeApplyImg(drawable, start, end);
	}
	
	public native void nativeApplyImg(Object image, int start, int end) /*-[
		NSMutableAttributedString *attributedString = ((NSMutableAttributedString*)attributedString_);
		NSTextAttachment *textAttachment = [[NSTextAttachment alloc] init];
		textAttachment.image = (UIImage*) image;
		NSAttributedString *attrStringWithImage = [NSAttributedString attributedStringWithAttachment:textAttachment];
		[attributedString replaceCharactersInRange:NSMakeRange(start, end - start) withAttributedString:attrStringWithImage];
	]-*/;

	@Override
	public native void applyBullet(int indent, int spacing, int start, int end) /*-[
		NSMutableParagraphStyle *const bulletParagraphStyle = [[NSParagraphStyle defaultParagraphStyle] mutableCopy];
		bulletParagraphStyle.headIndent = indent + spacing;
		bulletParagraphStyle.firstLineHeadIndent = indent;
		NSTextTab *listTab = [[NSTextTab alloc] initWithTextAlignment:NSTextAlignmentNatural location:indent+spacing options:@{}];
		bulletParagraphStyle.tabStops = @[listTab];

		[attributedString_ addAttributes:@{NSParagraphStyleAttributeName: bulletParagraphStyle} range:NSMakeRange(start, end - start)];
		
	]-*/;

	@Override
	public String getText() {
		return text;
	}

}
