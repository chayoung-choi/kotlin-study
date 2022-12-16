package domain


class ExtensionFunction {
    /**
     * 해당 값이 숫자인지
     */
    fun String.isInt(): Boolean = this.toIntOrNull() != null
}
