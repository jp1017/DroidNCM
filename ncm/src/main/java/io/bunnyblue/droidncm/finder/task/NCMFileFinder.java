package io.bunnyblue.droidncm.finder.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

import io.bunnyblue.droidncm.finder.MainFinderActivity;
import io.bunnyblue.droidncm.finder.dummy.NCMFileContent;

public class NCMFileFinder extends AsyncTask<File, Integer, NCMFileContent> {
    ProgressDialog progressDialog;
    Context context;
    public NCMFileFinder(Context context) {
        this.context = context;
    }

    @Override
    protected NCMFileContent doInBackground(File... files) {
        if (files != null) {
            File file = files[0];
            Collection<File> fileCollection = FileUtils.listFiles(file, new String[]{"ncm"}, true);
            NCMFileContent ncmFileContent = new NCMFileContent();
            for (File localFile :
                    fileCollection) {
                NCMFileContent.NCMLocalFile ncmLocalFile = new NCMFileContent.NCMLocalFile();
                ncmLocalFile.localPath = localFile.getAbsolutePath();
                ncmLocalFile.content = localFile.getName();
                ncmFileContent.addFile(ncmLocalFile);
                progressDialog.setMessage(ncmLocalFile.content);
            }
            return ncmFileContent;


        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //  ProgressDialog  builder = new ProgressDialog.Builder(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("searching...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(NCMFileContent ncmFileContent) {
        super.onPostExecute(ncmFileContent);
        progressDialog.dismiss();
        if (ncmFileContent == null) {
            Toast.makeText(context, "没有找到文件", Toast.LENGTH_SHORT).show();
        } else {
            ((MainFinderActivity) context).ncmFileContent = ncmFileContent;
            ((MainFinderActivity) context).updateNCMFileList();
        }

    }
}
