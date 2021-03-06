package com.example.android.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter;
import android.net.Uri;
import java.io.File;

public class SendIntent
{
    public static void sendText(Activity context,String text)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, text));
    }

    public static void sendUrl(Activity context, String text)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, text));
    }

    public static void sendTrack(Activity context, String url)
    {
        File file = new File(url);
        System.out.println(file.exists());
        Uri uri = Uri.fromFile(file);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.setType("audio/mp3");
        context.startActivity(Intent.createChooser(sendIntent, "Share track"));
    }

    public static void openFile(Activity context, String url)
    {
        File file = new File(url);
        Uri uri = Uri.fromFile(file);
        String mime = context.getContentResolver().getType(uri);


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);

        intent.setDataAndType(uri, mime);
        context.startActivity(Intent.createChooser(intent, "Open folder"));


//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_VIEW);
//        sendIntent.setDataAndType(uri, mime);
//        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(sendIntent);
    }

}
