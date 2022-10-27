package com.gmail.eamosse.tp2

interface StudentManager {
    /**
     * A list of Etudiants
     */
    fun listOf10(): List<Etudiant>

    /**
     * Sort list
     */
    fun sortAgeAscDesc(type: String): List<Etudiant>

    /**
     * Group Etudiants by sex
     */
    fun groupBySex(): Map<String, List<Etudiant>>

    /**
     * Filter Etudiant by sex
     */
    fun boysOrGirls(sexe: String): List<Etudiant>

    /**
     * Get list of Etudiant names
     */
    fun onlyNames(): List<String>

    /**
     * Delete Etudiant by sex
     */
    fun deleteBySex(sex: String)

    /**
     * Invert the list
     */
    fun reverse(): List<Etudiant>

    /**
     * Clear the list
     */
    fun clear()
}
