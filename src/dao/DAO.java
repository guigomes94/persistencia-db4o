package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import model.Author;
import model.Book;
import model.Genre;
import model.Loan;
import model.Reservation;
import model.User;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void open() {
		if (manager == null) {
			abrirBancoLocal();
			// abrirBancoServidor();
		}
	}

	public static void abrirBancoLocal() {
		// Backup.criar("banco.db4o");
		// new File("banco.db4o").delete(); //apagar o banco
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0); // 0,1,2,3...
		config.common().objectClass(User.class).cascadeOnUpdate(true);
		config.common().objectClass(User.class).cascadeOnActivate(true);
		
		config.common().objectClass(Author.class).cascadeOnUpdate(true);
		config.common().objectClass(Author.class).cascadeOnActivate(true);
		
		config.common().objectClass(Genre.class).cascadeOnUpdate(true);
		config.common().objectClass(Genre.class).cascadeOnActivate(true);
		
		config.common().objectClass(Book.class).cascadeOnActivate(true);
		
		config.common().objectClass(Reservation.class).cascadeOnActivate(true);
		
		config.common().objectClass(Loan.class).cascadeOnActivate(true);
		
		// indexacao de atributos
		
		config.common().objectClass(User.class).objectField("nome").indexed(true);
		config.common().objectClass(Book.class).objectField("title").indexed(true);

		manager = Db4oEmbedded.openFile(config, "banco.db4o");
	}

	/*
	 * public static void abrirBancoServidor(){ ClientConfiguration config =
	 * Db4oClientServer.newClientConfiguration( ) ; config.common().messageLevel(0);
	 * //0,1,2,3,4 config.common().objectClass(User.class).cascadeOnDelete(false);;
	 * config.common().objectClass(User.class).cascadeOnUpdate(true);;
	 * config.common().objectClass(User.class).cascadeOnActivate(true);
	 * config.common().objectClass(Autor.class).cascadeOnDelete(false);;
	 * config.common().objectClass(Autor.class).cascadeOnUpdate(true);;
	 * config.common().objectClass(Autor.class).cascadeOnActivate(true); //
	 * indexacao de atributos
	 * config.common().objectClass(User.class).objectField("titulo").indexed(true);
	 * config.common().objectClass(Autor.class).objectField("nome").indexed(true);
	 * 
	 * manager =
	 * Db4oClientServer.openClient(config,"127.0.0.1",34000,"usuario1","senha1"); }
	 */

	public static void close() {
		if (manager != null) {
			manager.close();
			manager = null;
		}
	}

	// ----------CRUD-----------------------

	public void create(T obj) {
		manager.store(obj);
	}

	public abstract T read(Object chave);

	public T update(T obj) {
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj) {
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll() {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}

	// --------transa��o---------------
	public static void begin() {
	} // tem que ser vazio

	public static void commit() {
		manager.commit();
	}

	public static void rollback() {
		manager.rollback();
	}

}
