/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Webserver;

import Applicationserver.Category;
import Applicationserver.PuzzleWord;
import Dataserver.AdministratorDAO;
import Dataserver.FortuneWheelDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "editPuzzleWordController")
@SessionScoped
public class EditPuzzleWordController implements Serializable {
    
    private PuzzleWord puzzleWord;
    private String editedPuzzleWord = "";
    private FortuneWheelDAO fortuneWheelDAO = new FortuneWheelDAO();
    
    public String editPuzzleWord(PuzzleWord puzzleWord){
        this.puzzleWord = puzzleWord;
        this.editedPuzzleWord = puzzleWord.getPuzzleWord();
        return "puzzleWordEdit.xhtml";
    }

    public PuzzleWord getPuzzleWord() {
        return puzzleWord;
    }

    public String getEditedPuzzleWord() {
        return editedPuzzleWord;
    }

    public void setPuzzleWord(PuzzleWord puzzleWord) {
        this.puzzleWord = puzzleWord;
    }

    public void setEditedPuzzleWord(String editedPuzzleWord) {
        this.editedPuzzleWord = editedPuzzleWord;
    }
    
    public String edit() throws SQLException, ClassNotFoundException{
        fortuneWheelDAO.editPuzzleWord(puzzleWord, editedPuzzleWord);
        return "/puzzleWord";
    }
}
