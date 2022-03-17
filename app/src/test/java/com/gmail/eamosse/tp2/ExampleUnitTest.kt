package com.gmail.eamosse.tp2

import com.gmail.eJohn.tp2.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private lateinit var items: List<Etudiant>

    @Before
    fun tearUp() {
        items = listOf(
            Etudiant(name = "John1", code = "A1", sexe = "M", address = "Lilles", age = 20),
            Etudiant(name = "John2", code = "A2", sexe = "F", address = "Lilles", age = 30),
            Etudiant(name = "John3", code = "A3", sexe = "F", address = "Lilles", age = 41),
            Etudiant(name = "John4", code = "A4", sexe = "M", address = "Lilles", age = 42),
            Etudiant(name = "John5", code = "A5", sexe = "M", address = "Lilles", age = 34),
            Etudiant(name = "John6", code = "A6", sexe = "F", address = "Lilles", age = 12),
            Etudiant(name = "John7", code = "A7", sexe = "M", address = "Lilles", age = 28),
            Etudiant(name = "John8", code = "A8", sexe = "M", address = "Lilles", age = 16),
            Etudiant(name = "John9", code = "A9", sexe = "F", address = "Lilles", age = 10),
            Etudiant(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56),
        )
    }

    @After
    fun tearDown() {
        items = listOf()
    }

    @Test
    fun listOf10_isCorrect() {
        assertEquals(10, listOf10().size)
    }

    @Test
    fun sortAgeAsc_isCorrect() {
        val result = sortAgeAscDesc(items, "ASC")
        val expectedFirst =
            Etudiant(name = "John9", code = "A9", sexe = "F", address = "Lilles", age = 10)
        val expectedLast =
            Etudiant(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56)
        assertEquals(expectedFirst, result.first())
        assertEquals(expectedLast, result.last())
    }

    @Test
    fun sortAgeDesc_isCorrect() {
        val result = sortAgeAscDesc(items, "DESC")
        val expectedFirst =
            Etudiant(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56)
        val expectedLast =
            Etudiant(name = "John9", code = "A9", sexe = "F", address = "Lilles", age = 10)
        assertEquals(expectedFirst, result.first())
        assertEquals(expectedLast, result.last())
    }

    @Test
    fun group_isCorrect() {
        val result = groupBySex(items)
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
            Etudiant(name = "John1", code = "A1", sexe = "M", address = "Lilles", age = 20),
            Etudiant(name = "John4", code = "A4", sexe = "M", address = "Lilles", age = 42),
            Etudiant(name = "John5", code = "A5", sexe = "M", address = "Lilles", age = 34),
            Etudiant(name = "John7", code = "A7", sexe = "M", address = "Lilles", age = 28),
            Etudiant(name = "John8", code = "A8", sexe = "M", address = "Lilles", age = 16),
        )
        val result = boysOrGirls(items, "M")
        assertArrayEquals("", boys.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun girl_isCorrect() {
        val girls = listOf(
            Etudiant(name = "John2", code = "A2", sexe = "F", address = "Lilles", age = 30),
            Etudiant(name = "John3", code = "A3", sexe = "F", address = "Lilles", age = 41),
            Etudiant(name = "John6", code = "A6", sexe = "F", address = "Lilles", age = 12),
            Etudiant(name = "John9", code = "A9", sexe = "F", address = "Lilles", age = 10),
            Etudiant(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56),
        )
        val result = boysOrGirls(items, "F")
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
        val result = onlyNames(items)
        assertArrayEquals("", expectedNames.toTypedArray(), result.toTypedArray())
    }

    @Test
    fun deleteBoys_isCorrect() {
        // Given mutable
        val _items = items.toMutableList()
        // When
        val result = deleteBySex(_items, "M")
        // Then
        assertEquals(5, _items.size)
        _items.forEach {
            assertNotEquals("M", it.sexe)
        }
    }


    @Test
    fun deleteGirls_isCorrect() {
        // Given mutable
        val _items = items.toMutableList()
        // When
        deleteBySex(_items, "F")
        // Then
        assertEquals(5, _items.size)
        _items.forEach {
            assertEquals("M", it.sexe)
        }
    }

    @Test
    fun reversed_isCorrect() {
        // Given mutable
        val _items = items.toMutableList()
        val last =
            Etudiant(name = "John10", code = "A10", sexe = "F", address = "Lilles", age = 56)
        val first =
            Etudiant(name = "John1", code = "A1", sexe = "M", address = "Lilles", age = 20)
        // When
        val result = inverseList(_items)
        // Then last should become first and vice versa
        assertEquals(last, result.first())
        assertEquals(first, result.last())
    }

    @Test
    fun emptyList_isCorrect() {
        // Given mutable
        val _items = items.toMutableList()
        // When
        emptyList(_items)
        // Then last should become first and vice versa
        assertTrue(_items.isEmpty())
    }


}