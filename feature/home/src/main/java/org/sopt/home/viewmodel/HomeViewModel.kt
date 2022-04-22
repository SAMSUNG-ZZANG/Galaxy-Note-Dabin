package org.sopt.home.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _followerList =
        MutableStateFlow<List<Pair<String, String>>>(listOf())
    val followerList: StateFlow<List<Pair<String, String>>>
        get() = _followerList.asStateFlow()

    private val _repositoryList =
        MutableStateFlow<List<Pair<String, String>>>(listOf())
    val repositoryList: StateFlow<List<Pair<String, String>>>
        get() = _repositoryList.asStateFlow()

    fun getFollowerList() {
        _followerList.value = listOf(
            Pair("우진실", "안뇽아뇬앙"),
            Pair("심채영", "하위하위하위"),
            Pair("강원용", "안드안드안드"),
            Pair("문다빈", "ㅋㅋㅎㅎㅋㅋ"),
            Pair("문리나", "ㅋㅋㅎㅎㅋㅋㅋ"),
            Pair("문스타", "엫후후후..")
        )
    }

    fun getRepositoryList() {
        _repositoryList.value = listOf(
            Pair("마이데일리", "마이데잉ㄹ릴리페포"),
            Pair("마스코타", "마스코타렐레"),
            Pair("가치사자", "사자레로포퐆"),
            Pair("얼리버디", "얼버 레포포포포포포"),
            Pair("빵동여지도", "빵동레포포포포포포포포포포"),
            Pair("리드미", "리드미레포")
        )
    }
}
