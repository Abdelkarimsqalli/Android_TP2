package com.gmail.eamosse.tp2

interface StudentManager {
    /**
     * A list of students
     */
    fun listOf10(): List<Student>

    /**
     * Sort list
     */
    fun sortAgeAscDesc(type: String): List<Student>

    /**
     * Group students by sex
     */
    fun groupBySex(): Map<String, List<Student>>

    /**
     * Filter student by sex
     */
    fun boysOrGirls(sexe: String): List<Student>

    /**
     * Get list of student names
     */
    fun onlyNames(): List<String>

    /**
     * Delete student by sex
     */
    fun deleteBySex(sex: String)

    /**
     * Invert the list
     */
    fun reverse(): List<Student>

    /**
     * Clear the list
     */
    fun clear()
}