/* Copyright (c) 2010 ARt Project owners
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.artgameweekend.projects.art.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.artgameweekend.projects.art.draw.BrushParameters;

/**
 *
 * @author pierre
 */
public class PreferencesService
{
    public static final String LAYAR = "Layar";
    public static final String WIKITUDE = "Wikitude";

    private static final String SHARED_PREFS_NAME = "art.preferences";
    private static final String KEY_BROWSER = "ar_browser";

    private static PreferencesService singleton = new PreferencesService();

    private PreferencesService()
    {
    }

    public static PreferencesService instance()
    {
        return singleton;
    }

    public String getAugmentedRealityBrowser( Activity activity )
    {
        SharedPreferences prefs = activity.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);
        return prefs.getString( KEY_BROWSER , LAYAR );

    }

    public void setAugmentedRealityBrowser( Activity activity , String browser)
    {
        SharedPreferences prefs = activity.getSharedPreferences( SHARED_PREFS_NAME, Activity.MODE_PRIVATE);
        Editor editor = prefs.edit();
        editor.putString( KEY_BROWSER, browser);
        editor.commit();

    }

    private static final String KEY_BRUSH_SIZE = "brush.size";
    private static final String KEY_BRUSH_COLOR = "brush.color";
    private static final String KEY_BRUSH_COLOR_BASE = "brush.color.base";
    private static final String KEY_BRUSH_COLOR_INTENSITY = "brush.color.intensity";
    private static final String KEY_BLUR_EFFECT = "brush.blur";
    private static final String KEY_EMBOSS_EFFECT = "brush.emboss";

    private static final int DEFAULT_BRUSH_SIZE = 12;
    private static final int DEFAULT_COLOR = 0xFFA5C739;
    private static final int DEFAULT_INTENSITY = 50;

    public void saveBrushParameters( Activity activity , BrushParameters bp )
    {
        SharedPreferences prefs = activity.getSharedPreferences( SHARED_PREFS_NAME, Activity.MODE_PRIVATE);
        Editor editor = prefs.edit();
        editor.putInt( KEY_BRUSH_SIZE, bp.getBrushSize() );
        editor.putInt( KEY_BRUSH_COLOR, bp.getColor() );
        editor.putInt( KEY_BRUSH_COLOR_BASE, bp.getColorBase() );
        editor.putInt( KEY_BRUSH_COLOR_INTENSITY, bp.getColorIntensity() );
        editor.putBoolean(KEY_BLUR_EFFECT , bp.isBlur() );
        editor.putBoolean(KEY_EMBOSS_EFFECT , bp.isEmboss() );
        editor.commit();
    }

    public void restoreBrushParameters( Activity activity , BrushParameters bp )
    {
        SharedPreferences prefs = activity.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);
        bp.setBrushSize( prefs.getInt( KEY_BRUSH_SIZE, DEFAULT_BRUSH_SIZE ));
        bp.setColor( prefs.getInt( KEY_BRUSH_COLOR, DEFAULT_COLOR ));
        bp.setColorBase( prefs.getInt( KEY_BRUSH_COLOR_BASE, DEFAULT_COLOR ));
        bp.setColorIntensity( prefs.getInt( KEY_BRUSH_COLOR_INTENSITY, DEFAULT_INTENSITY ));
        bp.setBrushSize( prefs.getInt( KEY_BRUSH_SIZE, DEFAULT_BRUSH_SIZE ));
        bp.setBlur( prefs.getBoolean( KEY_BLUR_EFFECT , false ));
        bp.setEmboss( prefs.getBoolean( KEY_EMBOSS_EFFECT , false ));
    }

}
