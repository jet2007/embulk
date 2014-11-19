package org.quickload.exec;

import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.common.base.Preconditions;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import org.quickload.time.TimestampFormatConfigSerDe;
import org.quickload.time.DateTimeZoneSerDe;
import org.quickload.config.ModelManager;
import org.quickload.record.TypeManager;
import org.quickload.config.DataSourceSerDe;
import org.quickload.config.EnumTaskSerDe;
import org.quickload.spi.ParserPlugin;

public class ExecModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        Preconditions.checkNotNull(binder, "binder is null.");
        binder.bind(ModelManager.class).in(Scopes.SINGLETON);
        binder.bind(TypeManager.class).asEagerSingleton();
        binder.bind(DataSourceSerDe.class).asEagerSingleton();
        binder.bind(EnumTaskSerDe.class).asEagerSingleton();
        binder.bind(TimestampFormatConfigSerDe.class).asEagerSingleton();
        binder.bind(DateTimeZoneSerDe.class).asEagerSingleton();
        binder.bind(BufferManager.class).in(Scopes.SINGLETON);
        binder.bind(ParserPlugin.class).annotatedWith(Names.named("system_guess")).to(GuessExecutor.GuessParserPlugin.class);
    }
}
