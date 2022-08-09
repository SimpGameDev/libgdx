package com.example.mygame;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TypeWriterAction extends Action {

    private Label label;
    private String[] phrases;
    private float letterDelay, phraseDelay;
    private int phraseIndex;
    private float letterTimeElapsed, phraseTimeElapsed;
    private int letterIndex;

    /**
     *
     * @param label
     * @param phrases Strings to display
     * @param phraseInterval pause between phrases
     * @param letterInterval pause between letters
     */
    public TypeWriterAction(Label label, String[] phrases, float phraseInterval, float letterInterval){
        this.label = label;
        this.phrases = phrases;
        this.phraseDelay = phraseInterval;
        this.letterDelay = letterInterval;
    }

    private void setPhrase(int index){
        phraseIndex = index;
        letterIndex = 0;
        phraseTimeElapsed = 0f;
        letterTimeElapsed = 0f;
    }

    /**
     * Updates the action based on time. Typically this is called each frame by {@link Actor#act(float)}.
     *
     * @param delta Time in seconds since the last frame.
     * @return true if the action is done. This method may continue to be called after the action is done.
     */
    @Override
    public boolean act(float delta) {
        if(letterIndex > phrases[phraseIndex].length()){
            if(phraseIndex >= phrases.length-1)
                return true;
            else {
                if(phraseTimeElapsed>=phraseDelay)
                    setPhrase(phraseIndex+1);
                else{
                    phraseTimeElapsed += delta;
                    return false;
                }
            }
        }
        else{
            letterTimeElapsed += delta;
            if(letterTimeElapsed >= letterDelay){
                label.setText(phrases[phraseIndex].substring(0,letterIndex));
                ++letterIndex;
                letterTimeElapsed = 0f;
            }
        }
        return false;
    }
}
