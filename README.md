# StringPaster - hotkey pasting testing tool

### Java + [keymaster](http://mvnrepository.com/artifact/com.github.tulskiy/jkeymaster/1.1)

Maven project, dependencies set in pom.xml

Some strings are taken from the [Big List of Naughty Strings](https://github.com/minimaxir/big-list-of-naughty-strings) - highly recommended source for all of your input needs!

## Requirements
* [JRE7+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

## Running
* use the jar file from the repo or compile it yourself using eclipse (project files included)
* script copies and pastes using the clipboard (simulating keystrokes) so make sure it's ok to lose clipboard data
* runs in background - to exit either use task manager or the CTRL+T shortcut

## Usage
Sets up the following hotkeys in the system (generates, moves to clipboard and pastes it):

CTRL+Q - 50 random characters from utf-8 (not all are visible!)

CTRL+W - A predefined sentence in a random language

CTRL+E - Random XSS string

CTRL+R - Random SQL Injection string

CTRL+T - Exits script

CTRL+1 - Random name

CTRL+2 - Random family name

CTRL+3 - Random email

CTRL+4 - Random password, always pastes the same one twice in a row
