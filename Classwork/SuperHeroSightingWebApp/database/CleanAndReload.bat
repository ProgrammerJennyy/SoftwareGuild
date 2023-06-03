@echo off

Rem Change working directory to location of sql files.
set batchdir=%cd%
cd %batchdir%

Rem  Reset Database
echo MySql Database user root:
"C:\Program Files\MySQL\MySQL Server 8.0\bin\MySQL" -u root -p superherosightings < DBandTables.sql
echo MySql Database user root:
"C:\Program Files\MySQL\MySQL Server 8.0\bin\MySQL" -u root -p superherosightings < TableData.sql

Pause