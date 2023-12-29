package com.message.messageapp.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.message.messageapp.models.ContactsModal;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Dao_Impl implements Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ContactsModal> __insertionAdapterOfContactsModal;

  public Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContactsModal = new EntityInsertionAdapter<ContactsModal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `contact_data` (`userName`,`contactNumber`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContactsModal value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
        if (value.getContactNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContactNumber());
        }
      }
    };
  }

  @Override
  public Object addContactNumber(final ContactsModal contactsModal,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfContactsModal.insert(contactsModal);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllContactNumber(final Continuation<? super List<ContactsModal>> continuation) {
    final String _sql = "SELECT * FROM contact_data";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ContactsModal>>() {
      @Override
      public List<ContactsModal> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "userName");
          final int _cursorIndexOfContactNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contactNumber");
          final List<ContactsModal> _result = new ArrayList<ContactsModal>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ContactsModal _item;
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            final String _tmpContactNumber;
            if (_cursor.isNull(_cursorIndexOfContactNumber)) {
              _tmpContactNumber = null;
            } else {
              _tmpContactNumber = _cursor.getString(_cursorIndexOfContactNumber);
            }
            _item = new ContactsModal(_tmpUserName,_tmpContactNumber);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public boolean isDataExist(final String contactNumber) {
    final String _sql = "SELECT * FROM contact_data WHERE contactNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (contactNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contactNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
