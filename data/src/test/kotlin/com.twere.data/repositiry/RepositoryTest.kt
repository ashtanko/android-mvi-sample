package com.twere.data.repositiry

import com.twere.data.DribbleItem
import com.twere.data.api.dribbble.model.Images
import org.junit.Test
import java.util.*

class RepositoryTest {

    var repos:List<DribbleItem> = ArrayList()

    init{
        val images = Images("", "", "")
        val date = Date()
        val tags = arrayListOf("")
        repos = arrayListOf(
                DribbleItem("one", 1L, 1L, images, 1L, 1L, 1L, 1L, 1L, 1L, date, date, "", "", "", "", "", "", "", false, tags),
                DribbleItem("two", 1L, 1L, images, 1L, 1L, 1L, 1L, 1L, 1L, date, date, "", "", "", "", "", "", "", false, tags),
                DribbleItem("three", 1L, 1L, images, 1L, 1L, 1L, 1L, 1L, 1L, date, date, "", "", "", "", "", "", "", false, tags)
        )
    }

    @Test
    fun trueTest(){
        assert(repos[0].description.equals("one"))
        assert(repos[1].description.equals("two"))
        assert(repos[2].description.equals("three"))
    }

    @Test
    fun falseTest(){
        assert(repos[0].description.equals("three"))
    }
}