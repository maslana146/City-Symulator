package com.bartoszmaslanka144091;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;


public class Program {
    private static Program instance;
    public static Program getInstance(){
        if (instance == null) {
            synchronized (Program.class) {
                if (instance == null) {
                    instance = new Program();
                }
            }
        }
        return instance;
    }
    public ObservableList<Wholesale> listOfWholesales = new ObservableList<Wholesale>() {
        @Override
        public void addListener(ListChangeListener<? super Wholesale> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Wholesale> listener) {

        }

        @Override
        public boolean addAll(Wholesale... elements) {
            return false;
        }

        @Override
        public boolean setAll(Wholesale... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Wholesale> col) {
            return false;
        }

        @Override
        public boolean removeAll(Wholesale... elements) {
            return false;
        }

        @Override
        public boolean retainAll(Wholesale... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Wholesale> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Wholesale wholesale) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Wholesale> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Wholesale> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Wholesale get(int index) {
            return null;
        }

        @Override
        public Wholesale set(int index, Wholesale element) {
            return null;
        }

        @Override
        public void add(int index, Wholesale element) {

        }

        @Override
        public Wholesale remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Wholesale> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Wholesale> listIterator(int index) {
            return null;
        }

        @Override
        public List<Wholesale> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };
    public ObservableList<RetailShop> listOfRetailShops = new ObservableList<RetailShop>() {
        @Override
        public void addListener(ListChangeListener<? super RetailShop> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super RetailShop> listener) {

        }

        @Override
        public boolean addAll(RetailShop... elements) {
            return false;
        }

        @Override
        public boolean setAll(RetailShop... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends RetailShop> col) {
            return false;
        }

        @Override
        public boolean removeAll(RetailShop... elements) {
            return false;
        }

        @Override
        public boolean retainAll(RetailShop... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<RetailShop> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(RetailShop retailShop) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends RetailShop> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends RetailShop> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public RetailShop get(int index) {
            return null;
        }

        @Override
        public RetailShop set(int index, RetailShop element) {
            return null;
        }

        @Override
        public void add(int index, RetailShop element) {

        }

        @Override
        public RetailShop remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<RetailShop> listIterator() {
            return null;
        }

        @Override
        public ListIterator<RetailShop> listIterator(int index) {
            return null;
        }

        @Override
        public List<RetailShop> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };
    public ArrayList<Supplier> listOfSuppliers =  new ArrayList<Supplier>();
    public ObservableList<Client> listOfClients = new ObservableList<Client>() {
        @Override
        public void addListener(ListChangeListener<? super Client> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Client> listener) {

        }

        @Override
        public boolean addAll(Client... elements) {
            return false;
        }

        @Override
        public boolean setAll(Client... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Client> col) {
            return false;
        }

        @Override
        public boolean removeAll(Client... elements) {
            return false;
        }

        @Override
        public boolean retainAll(Client... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Client> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Client client) {
            return true;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Client> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Client> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Client get(int index) {
            return null;
        }

        @Override
        public Client set(int index, Client element) {
            return null;
        }

        @Override
        public void add(int index, Client element) {

        }

        @Override
        public Client remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Client> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Client> listIterator(int index) {
            return null;
        }

        @Override
        public List<Client> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };

}
