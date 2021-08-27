package com.scorza5.androidtest.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID

class NotesDatabaseHelper(
    context: Context
):SQLiteOpenHelper(context, "databaseNotes", null, 1) {

    var DROP_TABLE = "DROP TABLE $TABLE_NOTES" + " IF EXISTS"
    var CREATE_TABLE = "CREATE TABLE $TABLE_NOTES (" +
            "$_ID INTEGER NOT NULL PRIMARY KEY, " +
            "$TITLE_NOTES TEXT NOT NULL" +
            "$DESCRIPTION_NOTES TEXT NOT NULL )"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(oldVersion != newVersion) {
            db?.execSQL(DROP_TABLE)
        }
        onCreate(db)
    }
    //colocar o add
    //colocar elementos na tabela pela activity

    companion object{
        const val TABLE_NOTES: String = "Notes"
        const val TITLE_NOTES:String = "title"
        const val DESCRIPTION_NOTES:String = "description"
    }

}