package forms.selection.events;

import forms.eventbus.Callback;

import java.util.Set;

/**
 * Created by User on 29.01.2017
 */
public abstract class GetMenuNamesCallback implements Callback{

    public abstract void onSuccess(Set<String> menuNames);
}