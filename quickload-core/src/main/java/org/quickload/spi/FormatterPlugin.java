package org.quickload.spi;

import org.quickload.config.ConfigSource;
import org.quickload.config.TaskSource;
import org.quickload.channel.PageInput;
import org.quickload.channel.FileBufferOutput;

public interface FormatterPlugin
{
    public TaskSource getFormatterTask(ProcTask proc, ConfigSource config);

    public void runFormatter(ProcTask proc,
            TaskSource taskSource, int processorIndex,
            PageInput pageInput, FileBufferOutput fileBufferOutput);
}
