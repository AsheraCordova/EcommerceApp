//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\css_parser\src\com\ashera\css\JavaCharStream.java
//

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "IOSPrimitiveArray.h"
#include "J2ObjC_source.h"
#include "JavaCharStream.h"
#include "java/io/IOException.h"
#include "java/io/InputStream.h"
#include "java/io/InputStreamReader.h"
#include "java/io/Reader.h"
#include "java/lang/Deprecated.h"
#include "java/lang/Error.h"
#include "java/lang/System.h"
#include "java/lang/Throwable.h"
#include "java/lang/annotation/Annotation.h"


__attribute__((unused)) static IOSObjectArray *CSSJavaCharStream__Annotations$0(void);

__attribute__((unused)) static IOSObjectArray *CSSJavaCharStream__Annotations$1(void);

@implementation CSSJavaCharStream

+ (jint)hexvalWithChar:(jchar)c {
  return CSSJavaCharStream_hexvalWithChar_(c);
}

- (void)setTabSizeWithInt:(jint)i {
  tabSize_ = i;
}

- (jint)getTabSize {
  return tabSize_;
}

- (void)ExpandBuffWithBoolean:(jboolean)wrapAround {
  IOSCharArray *newbuffer = [IOSCharArray arrayWithLength:bufsize_ + 2048];
  IOSIntArray *newbufline = [IOSIntArray arrayWithLength:bufsize_ + 2048];
  IOSIntArray *newbufcolumn = [IOSIntArray arrayWithLength:bufsize_ + 2048];
  @try {
    if (wrapAround) {
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, tokenBegin_, newbuffer, 0, bufsize_ - tokenBegin_);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, 0, newbuffer, bufsize_ - tokenBegin_, bufpos_);
      JreStrongAssign(&buffer_, newbuffer);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufline_, tokenBegin_, newbufline, 0, bufsize_ - tokenBegin_);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufline_, 0, newbufline, bufsize_ - tokenBegin_, bufpos_);
      JreStrongAssign(&bufline_, newbufline);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufcolumn_, tokenBegin_, newbufcolumn, 0, bufsize_ - tokenBegin_);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufcolumn_, 0, newbufcolumn, bufsize_ - tokenBegin_, bufpos_);
      JreStrongAssign(&bufcolumn_, newbufcolumn);
      bufpos_ += (bufsize_ - tokenBegin_);
    }
    else {
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, tokenBegin_, newbuffer, 0, bufsize_ - tokenBegin_);
      JreStrongAssign(&buffer_, newbuffer);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufline_, tokenBegin_, newbufline, 0, bufsize_ - tokenBegin_);
      JreStrongAssign(&bufline_, newbufline);
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(bufcolumn_, tokenBegin_, newbufcolumn, 0, bufsize_ - tokenBegin_);
      JreStrongAssign(&bufcolumn_, newbufcolumn);
      bufpos_ -= tokenBegin_;
    }
  }
  @catch (JavaLangThrowable *t) {
    @throw create_JavaLangError_initWithNSString_([t getMessage]);
  }
  available_ = (bufsize_ += 2048);
  tokenBegin_ = 0;
}

- (void)FillBuff {
  jint i;
  if (maxNextCharInd_ == 4096) maxNextCharInd_ = nextCharInd_ = 0;
  @try {
    if ((i = [((JavaIoReader *) nil_chk(inputStream_)) readWithCharArray:nextCharBuf_ withInt:maxNextCharInd_ withInt:4096 - maxNextCharInd_]) == -1) {
      [((JavaIoReader *) nil_chk(inputStream_)) close];
      @throw create_JavaIoIOException_init();
    }
    else maxNextCharInd_ += i;
    return;
  }
  @catch (JavaIoIOException *e) {
    if (bufpos_ != 0) {
      --bufpos_;
      [self backupWithInt:0];
    }
    else {
      *IOSIntArray_GetRef(nil_chk(bufline_), bufpos_) = line_;
      *IOSIntArray_GetRef(nil_chk(bufcolumn_), bufpos_) = column_;
    }
    @throw e;
  }
}

- (jchar)ReadByte {
  if (++nextCharInd_ >= maxNextCharInd_) [self FillBuff];
  return IOSCharArray_Get(nil_chk(nextCharBuf_), nextCharInd_);
}

- (jchar)BeginToken {
  if (inBuf_ > 0) {
    --inBuf_;
    if (++bufpos_ == bufsize_) bufpos_ = 0;
    tokenBegin_ = bufpos_;
    return IOSCharArray_Get(nil_chk(buffer_), bufpos_);
  }
  tokenBegin_ = 0;
  bufpos_ = -1;
  return [self readChar];
}

- (void)AdjustBuffSize {
  if (available_ == bufsize_) {
    if (tokenBegin_ > 2048) {
      bufpos_ = 0;
      available_ = tokenBegin_;
    }
    else [self ExpandBuffWithBoolean:false];
  }
  else if (available_ > tokenBegin_) available_ = bufsize_;
  else if ((tokenBegin_ - available_) < 2048) [self ExpandBuffWithBoolean:true];
  else available_ = tokenBegin_;
}

- (void)UpdateLineColumnWithChar:(jchar)c {
  column_++;
  if (prevCharIsLF_) {
    prevCharIsLF_ = false;
    line_ += (column_ = 1);
  }
  else if (prevCharIsCR_) {
    prevCharIsCR_ = false;
    if (c == 0x000a) {
      prevCharIsLF_ = true;
    }
    else line_ += (column_ = 1);
  }
  switch (c) {
    case 0x000d:
    prevCharIsCR_ = true;
    break;
    case 0x000a:
    prevCharIsLF_ = true;
    break;
    case 0x0009:
    column_--;
    column_ += (tabSize_ - (JreIntMod(column_, tabSize_)));
    break;
    default:
    break;
  }
  *IOSIntArray_GetRef(nil_chk(bufline_), bufpos_) = line_;
  *IOSIntArray_GetRef(nil_chk(bufcolumn_), bufpos_) = column_;
}

- (jchar)readChar {
  if (inBuf_ > 0) {
    --inBuf_;
    if (++bufpos_ == bufsize_) bufpos_ = 0;
    return IOSCharArray_Get(nil_chk(buffer_), bufpos_);
  }
  jchar c;
  if (++bufpos_ == available_) [self AdjustBuffSize];
  if ((*IOSCharArray_GetRef(nil_chk(buffer_), bufpos_) = c = [self ReadByte]) == '\\') {
    if (trackLineColumn_) {
      [self UpdateLineColumnWithChar:c];
    }
    jint backSlashCnt = 1;
    for (; ; ) {
      if (++bufpos_ == available_) [self AdjustBuffSize];
      @try {
        if ((*IOSCharArray_GetRef(nil_chk(buffer_), bufpos_) = c = [self ReadByte]) != '\\') {
          if (trackLineColumn_) {
            [self UpdateLineColumnWithChar:c];
          }
          if ((c == 'u') && ((backSlashCnt & 1) == 1)) {
            if (--bufpos_ < 0) bufpos_ = bufsize_ - 1;
            break;
          }
          [self backupWithInt:backSlashCnt];
          return '\\';
        }
      }
      @catch (JavaIoIOException *e) {
        if (backSlashCnt > 1) [self backupWithInt:backSlashCnt - 1];
        return '\\';
      }
      if (trackLineColumn_) {
        [self UpdateLineColumnWithChar:c];
      }
      backSlashCnt++;
    }
    @try {
      while ((c = [self ReadByte]) == 'u') ++column_;
      *IOSCharArray_GetRef(nil_chk(buffer_), bufpos_) = c = (jchar) ((JreLShift32(CSSJavaCharStream_hexvalWithChar_(c), 12)) | (JreLShift32(CSSJavaCharStream_hexvalWithChar_([self ReadByte]), 8)) | (JreLShift32(CSSJavaCharStream_hexvalWithChar_([self ReadByte]), 4)) | CSSJavaCharStream_hexvalWithChar_([self ReadByte]));
      column_ += 4;
    }
    @catch (JavaIoIOException *e) {
      @throw create_JavaLangError_initWithNSString_(JreStrcat("$I$IC", @"Invalid escape character at line ", line_, @" column ", column_, '.'));
    }
    if (backSlashCnt == 1) return c;
    else {
      [self backupWithInt:backSlashCnt - 1];
      return '\\';
    }
  }
  else {
    [self UpdateLineColumnWithChar:c];
    return c;
  }
}

- (jint)getColumn {
  return IOSIntArray_Get(nil_chk(bufcolumn_), bufpos_);
}

- (jint)getLine {
  return IOSIntArray_Get(nil_chk(bufline_), bufpos_);
}

- (jint)getEndColumn {
  return IOSIntArray_Get(nil_chk(bufcolumn_), bufpos_);
}

- (jint)getEndLine {
  return IOSIntArray_Get(nil_chk(bufline_), bufpos_);
}

- (jint)getBeginColumn {
  return IOSIntArray_Get(nil_chk(bufcolumn_), tokenBegin_);
}

- (jint)getBeginLine {
  return IOSIntArray_Get(nil_chk(bufline_), tokenBegin_);
}

- (void)backupWithInt:(jint)amount {
  inBuf_ += amount;
  if ((bufpos_ -= amount) < 0) bufpos_ += bufsize_;
}

- (instancetype)initPackagePrivateWithJavaIoReader:(JavaIoReader *)dstream
                                           withInt:(jint)startline
                                           withInt:(jint)startcolumn
                                           withInt:(jint)buffersize {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(self, dstream, startline, startcolumn, buffersize);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoReader:(JavaIoReader *)dstream
                                           withInt:(jint)startline
                                           withInt:(jint)startcolumn {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_(self, dstream, startline, startcolumn);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoReader:(JavaIoReader *)dstream {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_(self, dstream);
  return self;
}

- (void)ReInitWithJavaIoReader:(JavaIoReader *)dstream
                       withInt:(jint)startline
                       withInt:(jint)startcolumn
                       withInt:(jint)buffersize {
  JreStrongAssign(&inputStream_, dstream);
  line_ = startline;
  column_ = startcolumn - 1;
  if (buffer_ == nil || buffersize != buffer_->size_) {
    available_ = bufsize_ = buffersize;
    JreStrongAssignAndConsume(&buffer_, [IOSCharArray newArrayWithLength:buffersize]);
    JreStrongAssignAndConsume(&bufline_, [IOSIntArray newArrayWithLength:buffersize]);
    JreStrongAssignAndConsume(&bufcolumn_, [IOSIntArray newArrayWithLength:buffersize]);
    JreStrongAssignAndConsume(&nextCharBuf_, [IOSCharArray newArrayWithLength:4096]);
  }
  prevCharIsLF_ = prevCharIsCR_ = false;
  tokenBegin_ = inBuf_ = maxNextCharInd_ = 0;
  nextCharInd_ = bufpos_ = -1;
}

- (void)ReInitWithJavaIoReader:(JavaIoReader *)dstream
                       withInt:(jint)startline
                       withInt:(jint)startcolumn {
  [self ReInitWithJavaIoReader:dstream withInt:startline withInt:startcolumn withInt:4096];
}

- (void)ReInitWithJavaIoReader:(JavaIoReader *)dstream {
  [self ReInitWithJavaIoReader:dstream withInt:1 withInt:1 withInt:4096];
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream
                                           withNSString:(NSString *)encoding
                                                withInt:(jint)startline
                                                withInt:(jint)startcolumn
                                                withInt:(jint)buffersize {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(self, dstream, encoding, startline, startcolumn, buffersize);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream
                                                withInt:(jint)startline
                                                withInt:(jint)startcolumn
                                                withInt:(jint)buffersize {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(self, dstream, startline, startcolumn, buffersize);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream
                                           withNSString:(NSString *)encoding
                                                withInt:(jint)startline
                                                withInt:(jint)startcolumn {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_(self, dstream, encoding, startline, startcolumn);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream
                                                withInt:(jint)startline
                                                withInt:(jint)startcolumn {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_(self, dstream, startline, startcolumn);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream
                                           withNSString:(NSString *)encoding {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_(self, dstream, encoding);
  return self;
}

- (instancetype)initPackagePrivateWithJavaIoInputStream:(JavaIoInputStream *)dstream {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_(self, dstream);
  return self;
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream
                       withNSString:(NSString *)encoding
                            withInt:(jint)startline
                            withInt:(jint)startcolumn
                            withInt:(jint)buffersize {
  [self ReInitWithJavaIoReader:encoding == nil ? create_JavaIoInputStreamReader_initWithJavaIoInputStream_(dstream) : create_JavaIoInputStreamReader_initWithJavaIoInputStream_withNSString_(dstream, encoding) withInt:startline withInt:startcolumn withInt:buffersize];
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream
                            withInt:(jint)startline
                            withInt:(jint)startcolumn
                            withInt:(jint)buffersize {
  [self ReInitWithJavaIoReader:create_JavaIoInputStreamReader_initWithJavaIoInputStream_(dstream) withInt:startline withInt:startcolumn withInt:buffersize];
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream
                       withNSString:(NSString *)encoding
                            withInt:(jint)startline
                            withInt:(jint)startcolumn {
  [self ReInitWithJavaIoInputStream:dstream withNSString:encoding withInt:startline withInt:startcolumn withInt:4096];
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream
                            withInt:(jint)startline
                            withInt:(jint)startcolumn {
  [self ReInitWithJavaIoInputStream:dstream withInt:startline withInt:startcolumn withInt:4096];
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream
                       withNSString:(NSString *)encoding {
  [self ReInitWithJavaIoInputStream:dstream withNSString:encoding withInt:1 withInt:1 withInt:4096];
}

- (void)ReInitWithJavaIoInputStream:(JavaIoInputStream *)dstream {
  [self ReInitWithJavaIoInputStream:dstream withInt:1 withInt:1 withInt:4096];
}

- (NSString *)GetImage {
  if (bufpos_ >= tokenBegin_) return [NSString java_stringWithCharacters:buffer_ offset:tokenBegin_ length:bufpos_ - tokenBegin_ + 1];
  else return JreStrcat("$$", [NSString java_stringWithCharacters:buffer_ offset:tokenBegin_ length:bufsize_ - tokenBegin_], [NSString java_stringWithCharacters:buffer_ offset:0 length:bufpos_ + 1]);
}

- (IOSCharArray *)GetSuffixWithInt:(jint)len {
  IOSCharArray *ret = [IOSCharArray arrayWithLength:len];
  if ((bufpos_ + 1) >= len) JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, bufpos_ - len + 1, ret, 0, len);
  else {
    JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, bufsize_ - (len - bufpos_ - 1), ret, 0, len - bufpos_ - 1);
    JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(buffer_, 0, ret, len - bufpos_ - 1, bufpos_ + 1);
  }
  return ret;
}

- (void)Done {
  JreStrongAssign(&nextCharBuf_, nil);
  JreStrongAssign(&buffer_, nil);
  JreStrongAssign(&bufline_, nil);
  JreStrongAssign(&bufcolumn_, nil);
}

- (void)adjustBeginLineColumnWithInt:(jint)newLine
                             withInt:(jint)newCol {
  jint start = tokenBegin_;
  jint len;
  if (bufpos_ >= tokenBegin_) {
    len = bufpos_ - tokenBegin_ + inBuf_ + 1;
  }
  else {
    len = bufsize_ - tokenBegin_ + bufpos_ + 1 + inBuf_;
  }
  jint i = 0;
  jint j = 0;
  jint k = 0;
  jint nextColDiff = 0;
  jint columnDiff = 0;
  while (true) {
    jboolean unseq$1;
    if ((unseq$1 = (i < len))) {
      jint unseq$2 = start;
      unseq$1 = (unseq$1 && IOSIntArray_Get(nil_chk(bufline_), j = JreIntMod(unseq$2, bufsize_)) == IOSIntArray_Get(bufline_, k = JreIntMod(++start, bufsize_)));
    }
    if (!(unseq$1)) break;
    *IOSIntArray_GetRef(nil_chk(bufline_), j) = newLine;
    nextColDiff = columnDiff + IOSIntArray_Get(nil_chk(bufcolumn_), k) - IOSIntArray_Get(bufcolumn_, j);
    *IOSIntArray_GetRef(bufcolumn_, j) = newCol + columnDiff;
    columnDiff = nextColDiff;
    i++;
  }
  if (i < len) {
    *IOSIntArray_GetRef(nil_chk(bufline_), j) = newLine++;
    *IOSIntArray_GetRef(nil_chk(bufcolumn_), j) = newCol + columnDiff;
    while (i++ < len) {
      jint unseq$3 = start;
      if (IOSIntArray_Get(bufline_, j = JreIntMod(unseq$3, bufsize_)) != IOSIntArray_Get(bufline_, JreIntMod(++start, bufsize_))) *IOSIntArray_GetRef(bufline_, j) = newLine++;
      else *IOSIntArray_GetRef(bufline_, j) = newLine;
    }
  }
  line_ = IOSIntArray_Get(nil_chk(bufline_), j);
  column_ = IOSIntArray_Get(nil_chk(bufcolumn_), j);
}

- (jboolean)getTrackLineColumn {
  return trackLineColumn_;
}

- (void)setTrackLineColumnWithBoolean:(jboolean)tlc {
  trackLineColumn_ = tlc;
}

- (void)dealloc {
  RELEASE_(bufline_);
  RELEASE_(bufcolumn_);
  RELEASE_(inputStream_);
  RELEASE_(nextCharBuf_);
  RELEASE_(buffer_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "I", 0x18, 0, 1, 2, -1, -1, -1 },
    { NULL, "V", 0x1, 3, 4, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x4, 5, 6, -1, -1, -1, -1 },
    { NULL, "V", 0x4, -1, -1, 2, -1, -1, -1 },
    { NULL, "C", 0x4, -1, -1, 2, -1, -1, -1 },
    { NULL, "C", 0x1, -1, -1, 2, -1, -1, -1 },
    { NULL, "V", 0x4, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x4, 7, 1, -1, -1, -1, -1 },
    { NULL, "C", 0x1, -1, -1, 2, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, 8, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, 9, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 10, 4, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 11, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 12, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 13, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 11, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 12, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 13, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 15, 16, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 17, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 18, 16, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 19, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 20, 16, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 21, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 15, 16, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 18, 16, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 19, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 20, 16, -1, -1, -1 },
    { NULL, "V", 0x1, 14, 21, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "[C", 0x1, 22, 4, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 23, 24, -1, -1, -1, -1 },
    { NULL, "Z", 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x0, 25, 6, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(hexvalWithChar:);
  methods[1].selector = @selector(setTabSizeWithInt:);
  methods[2].selector = @selector(getTabSize);
  methods[3].selector = @selector(ExpandBuffWithBoolean:);
  methods[4].selector = @selector(FillBuff);
  methods[5].selector = @selector(ReadByte);
  methods[6].selector = @selector(BeginToken);
  methods[7].selector = @selector(AdjustBuffSize);
  methods[8].selector = @selector(UpdateLineColumnWithChar:);
  methods[9].selector = @selector(readChar);
  methods[10].selector = @selector(getColumn);
  methods[11].selector = @selector(getLine);
  methods[12].selector = @selector(getEndColumn);
  methods[13].selector = @selector(getEndLine);
  methods[14].selector = @selector(getBeginColumn);
  methods[15].selector = @selector(getBeginLine);
  methods[16].selector = @selector(backupWithInt:);
  methods[17].selector = @selector(initPackagePrivateWithJavaIoReader:withInt:withInt:withInt:);
  methods[18].selector = @selector(initPackagePrivateWithJavaIoReader:withInt:withInt:);
  methods[19].selector = @selector(initPackagePrivateWithJavaIoReader:);
  methods[20].selector = @selector(ReInitWithJavaIoReader:withInt:withInt:withInt:);
  methods[21].selector = @selector(ReInitWithJavaIoReader:withInt:withInt:);
  methods[22].selector = @selector(ReInitWithJavaIoReader:);
  methods[23].selector = @selector(initPackagePrivateWithJavaIoInputStream:withNSString:withInt:withInt:withInt:);
  methods[24].selector = @selector(initPackagePrivateWithJavaIoInputStream:withInt:withInt:withInt:);
  methods[25].selector = @selector(initPackagePrivateWithJavaIoInputStream:withNSString:withInt:withInt:);
  methods[26].selector = @selector(initPackagePrivateWithJavaIoInputStream:withInt:withInt:);
  methods[27].selector = @selector(initPackagePrivateWithJavaIoInputStream:withNSString:);
  methods[28].selector = @selector(initPackagePrivateWithJavaIoInputStream:);
  methods[29].selector = @selector(ReInitWithJavaIoInputStream:withNSString:withInt:withInt:withInt:);
  methods[30].selector = @selector(ReInitWithJavaIoInputStream:withInt:withInt:withInt:);
  methods[31].selector = @selector(ReInitWithJavaIoInputStream:withNSString:withInt:withInt:);
  methods[32].selector = @selector(ReInitWithJavaIoInputStream:withInt:withInt:);
  methods[33].selector = @selector(ReInitWithJavaIoInputStream:withNSString:);
  methods[34].selector = @selector(ReInitWithJavaIoInputStream:);
  methods[35].selector = @selector(GetImage);
  methods[36].selector = @selector(GetSuffixWithInt:);
  methods[37].selector = @selector(Done);
  methods[38].selector = @selector(adjustBeginLineColumnWithInt:withInt:);
  methods[39].selector = @selector(getTrackLineColumn);
  methods[40].selector = @selector(setTrackLineColumnWithBoolean:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "staticFlag", "Z", .constantValue.asBOOL = CSSJavaCharStream_staticFlag, 0x19, -1, -1, -1, -1 },
    { "bufpos_", "I", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
    { "bufsize_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "available_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "tokenBegin_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "bufline_", "[I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "bufcolumn_", "[I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "column_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "line_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "prevCharIsCR_", "Z", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "prevCharIsLF_", "Z", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "inputStream_", "LJavaIoReader;", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "nextCharBuf_", "[C", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "buffer_", "[C", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "maxNextCharInd_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "nextCharInd_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "inBuf_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "tabSize_", "I", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "trackLineColumn_", "Z", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "hexval", "C", "LJavaIoIOException;", "setTabSize", "I", "ExpandBuff", "Z", "UpdateLineColumn", (void *)&CSSJavaCharStream__Annotations$0, (void *)&CSSJavaCharStream__Annotations$1, "backup", "LJavaIoReader;III", "LJavaIoReader;II", "LJavaIoReader;", "ReInit", "LJavaIoInputStream;LNSString;III", "LJavaIoUnsupportedEncodingException;", "LJavaIoInputStream;III", "LJavaIoInputStream;LNSString;II", "LJavaIoInputStream;II", "LJavaIoInputStream;LNSString;", "LJavaIoInputStream;", "GetSuffix", "adjustBeginLineColumn", "II", "setTrackLineColumn" };
  static const J2ObjcClassInfo _CSSJavaCharStream = { "JavaCharStream", "com.ashera.css", ptrTable, methods, fields, 7, 0x0, 41, 19, -1, -1, -1, -1, -1 };
  return &_CSSJavaCharStream;
}

@end

jint CSSJavaCharStream_hexvalWithChar_(jchar c) {
  CSSJavaCharStream_initialize();
  switch (c) {
    case '0':
    return 0;
    case '1':
    return 1;
    case '2':
    return 2;
    case '3':
    return 3;
    case '4':
    return 4;
    case '5':
    return 5;
    case '6':
    return 6;
    case '7':
    return 7;
    case '8':
    return 8;
    case '9':
    return 9;
    case 'a':
    case 'A':
    return 10;
    case 'b':
    case 'B':
    return 11;
    case 'c':
    case 'C':
    return 12;
    case 'd':
    case 'D':
    return 13;
    case 'e':
    case 'E':
    return 14;
    case 'f':
    case 'F':
    return 15;
  }
  @throw create_JavaIoIOException_init();
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(CSSJavaCharStream *self, JavaIoReader *dstream, jint startline, jint startcolumn, jint buffersize) {
  NSObject_init(self);
  self->bufpos_ = -1;
  self->column_ = 0;
  self->line_ = 1;
  self->prevCharIsCR_ = false;
  self->prevCharIsLF_ = false;
  self->maxNextCharInd_ = 0;
  self->nextCharInd_ = -1;
  self->inBuf_ = 0;
  self->tabSize_ = 8;
  self->trackLineColumn_ = true;
  JreStrongAssign(&self->inputStream_, dstream);
  self->line_ = startline;
  self->column_ = startcolumn - 1;
  self->available_ = self->bufsize_ = buffersize;
  JreStrongAssignAndConsume(&self->buffer_, [IOSCharArray newArrayWithLength:buffersize]);
  JreStrongAssignAndConsume(&self->bufline_, [IOSIntArray newArrayWithLength:buffersize]);
  JreStrongAssignAndConsume(&self->bufcolumn_, [IOSIntArray newArrayWithLength:buffersize]);
  JreStrongAssignAndConsume(&self->nextCharBuf_, [IOSCharArray newArrayWithLength:4096]);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(JavaIoReader *dstream, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_, dstream, startline, startcolumn, buffersize)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(JavaIoReader *dstream, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_, dstream, startline, startcolumn, buffersize)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_(CSSJavaCharStream *self, JavaIoReader *dstream, jint startline, jint startcolumn) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(self, dstream, startline, startcolumn, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_(JavaIoReader *dstream, jint startline, jint startcolumn) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_withInt_withInt_, dstream, startline, startcolumn)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_(JavaIoReader *dstream, jint startline, jint startcolumn) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_withInt_withInt_, dstream, startline, startcolumn)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoReader_(CSSJavaCharStream *self, JavaIoReader *dstream) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(self, dstream, 1, 1, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_(JavaIoReader *dstream) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_, dstream)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoReader_(JavaIoReader *dstream) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoReader_, dstream)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(CSSJavaCharStream *self, JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn, jint buffersize) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(self, encoding == nil ? create_JavaIoInputStreamReader_initWithJavaIoInputStream_(dstream) : create_JavaIoInputStreamReader_initWithJavaIoInputStream_withNSString_(dstream, encoding), startline, startcolumn, buffersize);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_, dstream, encoding, startline, startcolumn, buffersize)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_, dstream, encoding, startline, startcolumn, buffersize)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(CSSJavaCharStream *self, JavaIoInputStream *dstream, jint startline, jint startcolumn, jint buffersize) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoReader_withInt_withInt_withInt_(self, create_JavaIoInputStreamReader_initWithJavaIoInputStream_(dstream), startline, startcolumn, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(JavaIoInputStream *dstream, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_, dstream, startline, startcolumn, buffersize)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(JavaIoInputStream *dstream, jint startline, jint startcolumn, jint buffersize) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_, dstream, startline, startcolumn, buffersize)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_(CSSJavaCharStream *self, JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(self, dstream, encoding, startline, startcolumn, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_(JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_, dstream, encoding, startline, startcolumn)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_(JavaIoInputStream *dstream, NSString *encoding, jint startline, jint startcolumn) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_, dstream, encoding, startline, startcolumn)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_(CSSJavaCharStream *self, JavaIoInputStream *dstream, jint startline, jint startcolumn) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(self, dstream, startline, startcolumn, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_(JavaIoInputStream *dstream, jint startline, jint startcolumn) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withInt_withInt_, dstream, startline, startcolumn)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_(JavaIoInputStream *dstream, jint startline, jint startcolumn) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withInt_withInt_, dstream, startline, startcolumn)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_(CSSJavaCharStream *self, JavaIoInputStream *dstream, NSString *encoding) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_withInt_withInt_withInt_(self, dstream, encoding, 1, 1, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_(JavaIoInputStream *dstream, NSString *encoding) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_, dstream, encoding)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withNSString_(JavaIoInputStream *dstream, NSString *encoding) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_withNSString_, dstream, encoding)
}

void CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_(CSSJavaCharStream *self, JavaIoInputStream *dstream) {
  CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_withInt_withInt_withInt_(self, dstream, 1, 1, 4096);
}

CSSJavaCharStream *new_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_(JavaIoInputStream *dstream) {
  J2OBJC_NEW_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_, dstream)
}

CSSJavaCharStream *create_CSSJavaCharStream_initPackagePrivateWithJavaIoInputStream_(JavaIoInputStream *dstream) {
  J2OBJC_CREATE_IMPL(CSSJavaCharStream, initPackagePrivateWithJavaIoInputStream_, dstream)
}

IOSObjectArray *CSSJavaCharStream__Annotations$0() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated() } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

IOSObjectArray *CSSJavaCharStream__Annotations$1() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangDeprecated() } count:1 type:JavaLangAnnotationAnnotation_class_()];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(CSSJavaCharStream)
