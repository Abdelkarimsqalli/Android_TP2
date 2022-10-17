package com.gmail.eamosse.tp2

import com.gmail.eamosse.tp2.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LocalStudentManagerTest {
    private lateinit var manager: StudentManager

    /**
     * This will run before each test
     */
    @Before
    fun tearUp() {
        // TODO create an instance of the local student manager
    }

    @After
    fun tearDown() {
        // Clear up things, if needed
    }

    @Test
    fun listOf10_isCorrect() {
        assertEquals(10, manager.listOf10().size)
    }

    @Test
    fun sortAgeAsc_isCorrect() {
        val result = manager.sortAgeAscDesc("ASC")
        assertEquals(10, result.first().age)
        assertEquals(16, result.last().age)
    }

    @Test
    fun sortAgeDesc_isCorrect() {
        val result = manager.sortAgeAscDesc("DESC")
        assertEquals(56, result.first().age)
        assertEquals(10, result.last().age)
    }

    @Test
    fun group_isCorrect() {
        val result = manager.groupBySex()
        assertFalse(result.isEmpty())
        assertEquals(2, result.keys.size)
        assertTrue(result.containsKey("M"))
        assertTrue(result.containsKey("F"))
        assertEquals(5, result["M"]?.size)
        assertEquals(5, result["F"]?.size)
    }

    @Test
    fun boy_isCorrect() {
        val boys = listOf(
            Student(name = "John1", code = "A1", sexe = "M", address = "Lilles", age = 20),
            Student(name = "John4", code = "A4", sexe = "M", address = "Lilles", age = 42),
            Student(name = "John5", code = "A5", sexe = "M", address = "Lilles", age = 34),
            Student(name = "John7", code = "A7", sexe = "M", address = "Lilles", age = 28),
            Student(name = "John8", code = "A8", sexe = "M", address = "Lilles", age = 16),
        )
        val result = manager.boysOrGirls("M")
        assertArrayEquals("", boys.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun girl_isCorrect() {
        val girls = listOf(
            Student(name = "John2", code = "A2", sexe = "F", address = "Lilles", age = 30),
            Student(name = "John3", code = "A3", sexe = "F", address = "Lilles", age = 41),
            Student(name = "John6", code = "A6", sexe = "F", address = "Lilles", age = 12),
            Student(name = "John9", code = "A9", sexe = "F", address = "Lilles", age = 10),
            Student(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56),
        )
        val result = manager.boysOrGirls("F")
        assertArrayEquals("", girls.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun only_names_isCorrect() {
        val expectedNames = listOf(
            "John1",
            "John2",
            "John3",
            "John4",
            "John5",
            "John6",
            "John7",
            "John8",
            "John9",
            "John10"
        )
        val result = manager.onlyNames()
        assertArrayEquals("", expectedNames.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun deleteBoys_isCorrect() {
        // When
        manager.deleteBySex("M")
        // Then
        manager.listOf10().forEach {
            assertNotEquals("M", it.sexe)
        }
    }


    @Test
    fun deleteGirls_isCorrect() {
        // When
        manager.deleteBySex("F")
        // Then
        manager.listOf10().forEach {
            assertEquals("M", it.sexe)
        }
    }

    @Test
    fun reversed_isCorrect() {
        val last =
            Student(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56)
        val first =
            Student(name = "John1", code = "A1", sexe = "M", address = "Lilles", age = 20)
        // When
        val result = manager.reverse()
        // Then last should become first and vice versa
        assertEquals(last, result.first())
        assertEquals(first, result.last())
    }

    @Test
    fun emptyList_isCorrect() {
        // When
        manager.clear()
        // Then last should become first and vice versa
        assertTrue(manager.listOf10().isEmpty())
    }


}