package com.sabeel.obdreader.io;

public interface ObdProgressListener {

    void stateUpdate(final ObdCommandJob job);

}