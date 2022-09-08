package com.dynast.kin_eduwill.ui.main.view.home.items

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.dynast.kin_eduwill.R

sealed class ProcessStyleItems(
    val title: String,
    val content: String,
    val brash: Brush,
    @StringRes val type: Int
) {
    object Kar : ProcessStyleItems(
        title = "공다방 상담소 오픈",
        content = "고민 해결,『공다방 상담소』OPEN♥",
        brash = Brush.linearGradient(
            0.0f to Color(0xffCA7646),
            0.5f to Color(0xffB5623A),
            1.0f to Color(0xffA55431),
        ), type = R.string.kar
    )

    object Official : ProcessStyleItems(
        title = "공시생 필수템 월드컵",
        content = "댓글 공유하고 선물 받아가세요!",
        brash = Brush.linearGradient(
            0.0f to Color(0xff006AE1),
            0.5f to Color(0xff0058D5),
            1.0f to Color(0xff004BCB),
        ), type = R.string.official
    )

    object Engineer : ProcessStyleItems(
        title = "8월 내공자판기",
        content = "오픈일정 공지",
        brash = Brush.linearGradient(
            0.0f to Color(0xffFEC41B),
            0.5f to Color(0xffFEB217),
            1.0f to Color(0xffFEA514),
        ), type = R.string.engineer
    )

    object Default : ProcessStyleItems(
        title = "전국민 합격 프로젝트",
        content = "사연을 남기면 평생패스를 드려요!",
        brash = Brush.verticalGradient(
            0.0f to Color(0xffFFFFFF),
            1.0f to Color(0xffF2F6FF)
        ), type = R.string.company
    )
}
