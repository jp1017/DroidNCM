package io.bunnyblue.droidncm.finder.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;

import io.bunnyblue.droidncm.dump.NcmDumper;

public class FileConvertTask extends AsyncTask<File, String, Integer> {
    ProgressDialog progressDialog;
    Context context;
    public FileConvertTask(Context context) {
        this.context = context;
    }

    @Override
    protected Integer doInBackground(File... files) {
        int index = 0;
        // if (files.length=)
        for (File srcFile : files) {
            publishProgress(srcFile.getName());
            String targetFile = NcmDumper.ncpDump(srcFile.getAbsolutePath());
            File target = new File(targetFile);
            if (target.exists()) {
                publishProgress(target.getAbsolutePath());
                index++;
                //  return target;
            }
        }


        return index;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        if (values[0].startsWith("/")) {
            progressDialog.setMessage(String.format("success process  file %s", values[0]));
        } else {
            progressDialog.setMessage(String.format("processing file %s ..", values[0]));
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("正在处理");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Integer file) {
        super.onPostExecute(file);
        progressDialog.dismiss();

        if (file != 0) {
            Toast.makeText(context, "new file  count :" + file, Toast.LENGTH_SHORT).show();
        }
    }

}
