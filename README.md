# Java File Organizer CLI

A command-line Java utility that organizes files in a directory by file type, grouping them into folders like `IMAGES/`, `DOCUMENTS/`, `AUDIO/`, and `OTHERS/`.

---

## Features

- 📁 Automatically sorts files by extension into categorized folders.
- ✅ Handles common formats: images, documents, spreadsheets, archives, audio, video, and code files.
- 🚫 Skips existing files and directories (does not overwrite).
- 🛑 Prints clear messages for errors and invalid files.
- 📈 Summary report after running: number of files moved, skipped, and errors.
- 🧱 Clean object-oriented code structure (easy to extend and improve).

---

## Usage

### 1. **Clone the Repository**

```sh
git clone https://github.com/YOUR-USERNAME/YOUR-REPO-NAME.git
cd YOUR-REPO-NAME
```

### 2. **Compile the Java Files**

```sh
javac app/Main.java organizer/CategoryResolver.java organizer/FileOrganizer.java model/Summary.java
```

### 3. **Run the Application**

```sh
java app.Main
```

You will be prompted to enter the path of the directory you want to organize.

---

## Example

**Before running:**

```
Downloads/
  file1.jpg
  file2.pdf
  song.mp3
  notes.txt
  image2.png
  archive.zip
```

**After running:**

```
Downloads/
  IMAGES/
    file1.jpg
    image2.png
  DOCUMENTS/
    file2.pdf
    notes.txt
  AUDIO/
    song.mp3
  ARCHIVES/
    archive.zip
```

---

## Output Sample

```text
=== Java File Organizer CLI ===
Enter the directory path to organize: /Users/yourname/Downloads
Moved: file1.jpg -> IMAGES/
Moved: file2.pdf -> DOCUMENTS/
Moved: song.mp3 -> AUDIO/
Moved: notes.txt -> DOCUMENTS/
Moved: image2.png -> IMAGES/
Moved: archive.zip -> ARCHIVES/

--- Organizing Summary ---
Moved:
  IMAGES: 2
  DOCUMENTS: 2
  AUDIO: 1
  ARCHIVES: 1
Skipped: 0
Errors: 0

Done!
```

---

## How It Works

1. The user provides a target directory.
2. The app scans all files in the top level (not recursive).
3. For each file, it:
    - Determines its extension
    - Resolves its category (e.g., IMAGES, DOCUMENTS)
    - Moves it into a matching subfolder (creating folders as needed)
4. Prints progress and a summary report.

---

## Extending the Project

- Add recursive scanning for subfolders
- Add "dry-run" mode
- Read custom extension mappings from a config file
- Implement multi-threaded file processing
- Add unit tests

---

## License

This project is open-source and available under the MIT License.

---

## Author

[Mohamed Noaman](https://github.com/MohamedNoaman705)

---

Feel free to contribute or open issues!
