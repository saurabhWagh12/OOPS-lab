public void growArray(T s) {
    sizeArray = (int) Math.ceil(sizeArray * 1.5);
    Object[] adash = new Object[sizeArray];
    for (int i = 0; i < count; i++) {
        adash[i] = array[i];
    }
    adash[count] = s;
    array = adash;
    count++;
}