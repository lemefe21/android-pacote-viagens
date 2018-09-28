package br.com.fleme.pacoteviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public static final String DEF_TYPE = "drawable";

    public static Drawable retornaDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmTexto, DEF_TYPE, context.getPackageName());
        return resources.getDrawable(idDrawable);
    }

}
