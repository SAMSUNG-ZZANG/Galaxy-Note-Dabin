package org.sopt.core.util.ext

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

fun Fragment.replace(@IdRes frameId: Int, fragment: Fragment) {
    requireActivity().supportFragmentManager
        .beginTransaction()
        .replace(frameId, fragment, null)
        .commit()
}

fun Fragment.stringListFrom(id: Int): List<String> =
    requireContext().resources.getStringArray(id).toList()
