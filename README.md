# libgdx
[TypeWriterAction.java](TypeWriterAction.java) - provides a typewriter animation for labels.  
Update: no more additional String object creation through substring, but direct access to the Label's StringBuilder object.
## Pros:  
- usable like a regular action with scene2d.ui elements like Label or TextButton (see [MyGdxGame.java](MyGdxGame.java)).  
- single Java class, no lib
- no funny [license](https://github.com/SimpGameDev/libgdx/blob/main/LICENSE) attached to it, just CC0.  

## Cons:  
- not as feature rich as these libs:  
-- [typing-label](https://github.com/rafaskb/typing-label)  
-- [textratypist](https://github.com/tommyettinger/textratypist)
