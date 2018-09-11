LOCAL_PATH := $(call my-dir)
DROID_NCM_ROOT := $(call my-dir)
LOCAL_MODULE    := taglib

LOCAL_SRC_FILES :=  wavpack/wavpackfile.cpp \
                    wavpack/wavpackproperties.cpp \
                    s3m/s3mproperties.cpp \
                    s3m/s3mfile.cpp \
                    fileref.cpp \
                    ogg/oggfile.cpp \
                    ogg/vorbis/vorbisfile.cpp \
                    ogg/vorbis/vorbisproperties.cpp \
                    ogg/opus/opusproperties.cpp \
                    ogg/opus/opusfile.cpp \
                    ogg/oggpageheader.cpp \
                    ogg/speex/speexproperties.cpp \
                    ogg/speex/speexfile.cpp \
                    ogg/xiphcomment.cpp \
                    ogg/oggpage.cpp \
                    ogg/flac/oggflacfile.cpp \
                    trueaudio/trueaudioproperties.cpp \
                    trueaudio/trueaudiofile.cpp \
                    ape/apeproperties.cpp \
                    ape/apefile.cpp \
                    ape/apefooter.cpp \
                    ape/apetag.cpp \
                    ape/apeitem.cpp \
                    mpeg/mpegfile.cpp \
                    mpeg/id3v2/id3v2footer.cpp \
                    mpeg/id3v2/id3v2header.cpp \
                    mpeg/id3v2/id3v2frame.cpp \
                    mpeg/id3v2/frames/synchronizedlyricsframe.cpp \
                    mpeg/id3v2/frames/uniquefileidentifierframe.cpp \
                    mpeg/id3v2/frames/privateframe.cpp \
                    mpeg/id3v2/frames/unknownframe.cpp \
                    mpeg/id3v2/frames/eventtimingcodesframe.cpp \
                    mpeg/id3v2/frames/unsynchronizedlyricsframe.cpp \
                    mpeg/id3v2/frames/podcastframe.cpp \
                    mpeg/id3v2/frames/commentsframe.cpp \
                    mpeg/id3v2/frames/chapterframe.cpp \
                    mpeg/id3v2/frames/tableofcontentsframe.cpp \
                    mpeg/id3v2/frames/generalencapsulatedobjectframe.cpp \
                    mpeg/id3v2/frames/relativevolumeframe.cpp \
                    mpeg/id3v2/frames/ownershipframe.cpp \
                    mpeg/id3v2/frames/attachedpictureframe.cpp \
                    mpeg/id3v2/frames/textidentificationframe.cpp \
                    mpeg/id3v2/frames/urllinkframe.cpp \
                    mpeg/id3v2/frames/popularimeterframe.cpp \
                    mpeg/id3v2/id3v2synchdata.cpp \
                    mpeg/id3v2/id3v2framefactory.cpp \
                    mpeg/id3v2/id3v2extendedheader.cpp \
                    mpeg/id3v2/id3v2tag.cpp \
                    mpeg/mpegheader.cpp \
                    mpeg/xingheader.cpp \
                    mpeg/id3v1/id3v1genres.cpp \
                    mpeg/id3v1/id3v1tag.cpp \
                    mpeg/mpegproperties.cpp \
                    riff/wav/infotag.cpp \
                    riff/wav/wavfile.cpp \
                    riff/wav/wavproperties.cpp \
                    riff/aiff/aiffproperties.cpp \
                    riff/aiff/aifffile.cpp \
                    riff/rifffile.cpp \
                    it/itfile.cpp \
                    it/itproperties.cpp \
                    audioproperties.cpp \
                    tag.cpp \
                    flac/flacmetadatablock.cpp \
                    flac/flacfile.cpp \
                    flac/flacpicture.cpp \
                    flac/flacunknownmetadatablock.cpp \
                    flac/flacproperties.cpp \
                    mpc/mpcproperties.cpp \
                    mpc/mpcfile.cpp \
                    tagutils.cpp \
                    mp4/mp4tag.cpp \
                    mp4/mp4file.cpp \
                    mp4/mp4coverart.cpp \
                    mp4/mp4atom.cpp \
                    mp4/mp4item.cpp \
                    mp4/mp4properties.cpp \
                    asf/asfpicture.cpp \
                    asf/asfattribute.cpp \
                    asf/asftag.cpp \
                    asf/asfproperties.cpp \
                    asf/asffile.cpp \
                    tagunion.cpp \
                    xm/xmfile.cpp \
                    xm/xmproperties.cpp \
                    toolkit/tbytevectorstream.cpp \
                    toolkit/tdebug.cpp \
                    toolkit/tstringlist.cpp \
                    toolkit/tdebuglistener.cpp \
                    toolkit/tfile.cpp \
                    toolkit/tbytevector.cpp \
                    toolkit/tstring.cpp \
                    toolkit/trefcounter.cpp \
                    toolkit/tpropertymap.cpp \
                    toolkit/tiostream.cpp \
                    toolkit/tfilestream.cpp \
                    toolkit/unicode.cpp \
                    toolkit/tbytevectorlist.cpp \
                    toolkit/tzlib.cpp \
                    mod/modtag.cpp \
                    mod/modfilebase.cpp \
                    mod/modfile.cpp \
                    mod/modproperties.cpp






LOCAL_C_INCLUDES :=  . \
                    ogg/speex \
                    xm \
                    ogg/vorbis \
                    riff/wav \
                    s3m \
                    trueaudio \
                    ape \
                    mp4 \
                    riff/aiff \
                    mpeg \
                    mpeg/id3v1 \
                    mpc \
                    ogg/flac \
                    it \
                    ogg/opus \
                    mod \
                    mpeg/id3v2/frames \
                    toolkit \
                    ogg \
                    riff \
                    flac \
                    asf \
                    mpeg/id3v2 \
                    wavpack


LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_C_INCLUDES)
include $(BUILD_STATIC_LIBRARY)
include $(CLEAR_VARS)

LOCAL_PATH = $(DROID_NCM_ROOT)

LOCAL_MODULE    := libcrypto
LOCAL_SRC_FILES := openssl-lib/$(TARGET_ARCH_ABI)/libcrypto.a
LOCAL_EXPORT_C_INCLUDES := openssl-lib/$(TARGET_ARCH_ABI)/include

include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_PATH = $(DROID_NCM_ROOT)
LOCAL_MODULE    := ncm

LOCAL_SRC_FILES :=  _ncm/cJSON.cpp \
                    _ncm/main.cpp






LOCAL_C_INCLUDES +=  . \
                    ogg/speex \
                    xm \
                    ogg/vorbis \
                    riff/wav \
                    s3m \
                    trueaudio \
                    ape \
                    mp4 \
                    riff/aiff \
                    mpeg \
                    mpeg/id3v1 \
                    mpc \
                    ogg/flac \
                    it \
                    ogg/opus \
                    mod \
                    mpeg/id3v2/frames \
                    toolkit \
                    ogg \
                    riff \
                    flac \
                    asf \
                    mpeg/id3v2 \
                    wavpack


LOCAL_STATIC_LIBRARIES:= libcrypto libtaglib

include $(BUILD_SHARED_LIBRARY)