package com.example.mygame;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.StringBuilder;

/**
 * Provides a typing or typewriter animation for scene2d.ui Label and TextButton.
 * 
 */

public class TypeWriterAction extends Action {

    private Label label;
    private StringBuilder stb;
    private CharSequence[] texts;
    private int textIndex, charIndex;
    private float charInterval,charIntervalElapsed, textInterval, textIntervalElapsed;

   
    public TypeWriterAction(Label label, CharSequence[] texts, float textInterval, float charInterval){
        this.label = label;
        this.texts = texts;
        this.textInterval = textInterval;
        this.charInterval = charInterval;
        stb = label.getText();
    }

    private void setText(int index){
        textIndex = index;
        charIndex = 0;
        textIntervalElapsed = 0f;
        charIntervalElapsed = 0f;
        stb.clear();
    }

    /**
     * Updates the action based on time. Typically this is called each frame by {@link Actor#act(float)}.
     *
     * @param delta Time in seconds since the last frame.
     * @return true if the action is done. This method may continue to be called after the action is done.
     */
    @Override
    public boolean act(float delta) {
        if(charIndex >= texts[textIndex].length()){
            if(textIndex >= texts.length-1)
                return true;
            else {
                if(textIntervalElapsed>=textInterval)
                    setText(textIndex+1);
                else{
                    textIntervalElapsed += delta;
                    return false;
                }
            }
        }
        else{
            charIntervalElapsed += delta;
            if(charIntervalElapsed >= charInterval){
                stb.append(texts[textIndex].charAt(charIndex));
                label.invalidate();
                ++charIndex;
                charIntervalElapsed = 0f;
            }
        }
        return false;
    }
}
