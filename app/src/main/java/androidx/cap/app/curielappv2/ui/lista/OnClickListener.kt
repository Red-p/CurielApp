package androidx.cap.app.curielappv2.ui.lista



class OnClickListener<T>(val clickListener: (item: T) -> Unit) {
    fun onClick(item: T) = clickListener(item)
}