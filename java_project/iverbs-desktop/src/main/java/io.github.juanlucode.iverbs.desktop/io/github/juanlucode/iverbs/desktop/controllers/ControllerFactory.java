package io.github.juanlucode.iverbs.desktop.controllers;

import io.github.juanlucode.iverbs.desktop.front.MainAppFx;
import io.github.juanlucode.iverbs.desktop.front.View;

/**
 * Factory Pattern to get controllers
 *
 * @author juanluis
 *
 */
public final class ControllerFactory {

    public static Controller get(MainAppFx _app, View _view) {
        switch (_view) {
            case MENU:
                return new MenuController(_app);
            case QUESTION:
                return new QuestionController(_app);
            case RESULT:
                return new ResultController(_app);
            default:
                return null;
        }
    }

}
