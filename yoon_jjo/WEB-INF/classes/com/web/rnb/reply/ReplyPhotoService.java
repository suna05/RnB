package com.web.rnb.reply;

import java.util.List;

public interface ReplyPhotoService {

    void insertReply(ReplyPhotoDTO rdto);

    List<ReplyPhotoDTO> getListReply(int p_no);

    void updatePhotoReply(ReplyPhotoDTO rdto);
    void deletePhotoReply(ReplyPhotoDTO rdto);
}