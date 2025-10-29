package com.example.jouda

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        findViewById<TextView>(R.id.nav_nurseries).setOnClickListener { Toast.makeText(this, "المشتلات", Toast.LENGTH_SHORT).show() }
        findViewById<TextView>(R.id.nav_experts).setOnClickListener { showExperts() }
        findViewById<TextView>(R.id.nav_equipment).setOnClickListener { showEquipment() }
        findViewById<TextView>(R.id.nav_land).setOnClickListener { showLandForRent() }
        findViewById<TextView>(R.id.nav_products).setOnClickListener { showFarmerProducts() }
        findViewById<TextView>(R.id.nav_offers).setOnClickListener { Toast.makeText(this, "العروض المميزة", Toast.LENGTH_SHORT).show() }
        findViewById<TextView>(R.id.nav_ads).setOnClickListener { Toast.makeText(this, "الإعلانات", Toast.LENGTH_SHORT).show() }
        findViewById<TextView>(R.id.nav_search).setOnClickListener { Toast.makeText(this, "البحث", Toast.LENGTH_SHORT).show() }
        findViewById<TextView>(R.id.nav_notifications).setOnClickListener { showSmartNotifications() }
        findViewById<TextView>(R.id.nav_account).setOnClickListener { showSettings() }
    }

    private fun showExperts() {
        val expert = "الاسم: أحمد بلقاسم\nالمهنة: خبير زراعي\nالمكان: ولاية وهران\nسنوات الخبرة: 12"
        AlertDialog.Builder(this)
            .setTitle("خبير زراعي")
            .setMessage(expert)
            .setPositiveButton("اتصل") { _, _ -> }
            .show()
    }

    private fun showEquipment() {
        val equipment = "الاسم: علي داود\nنوع المعدات: جرار زراعي\nالمكان: ولاية البليدة"
        AlertDialog.Builder(this)
            .setTitle("المعدات الفلاحية")
            .setMessage(equipment)
            .setPositiveButton("اتصل") { _, _ -> }
            .show()
    }

    private fun showLandForRent() {
        val land = "اسم المالك: خالد مرابط\nمساحة الأرض: 5 هكتار\nمكان الأرض: دائرة سيدي عمار، ولاية تيارت"
        AlertDialog.Builder(this)
            .setTitle("أراضي زراعية للكراء")
            .setMessage(land)
            .setPositiveButton("عرض الموقع") { _, _ -> }
            .show()
    }

    private fun showFarmerProducts() {
        val categories = arrayOf("فواكه", "خضر", "عسل", "تمور", "حبوب", "شتلات")
        AlertDialog.Builder(this)
            .setTitle("منتجات الفلاحين")
            .setItems(categories) { _, which ->
                val details = when (categories[which]) {
                    "فواكه" -> "اسم الفلاح: سليمان\nموقع المزرعة: معسكر\nالمنتج: تفاح\nالسعر: 80 دج/كلغ\nالكمية: 200 كلغ\nالمبيدات: عضوية"
                    "خضر" -> "اسم الفلاح: فاطمة\nموقع المزرعة: سطيف\nالمنتج: طماطم\nالسعر: 40 دج/كلغ\nالكمية: 500 كلغ\nالمبيدات: منخفضة"
                    else -> "معلومات عن $categories[which]"
                }
                AlertDialog.Builder(this)
                    .setTitle(categories[which])
                    .setMessage(details)
                    .setPositiveButton("طلب") { _, _ -> }
                    .show()
            }
            .show()
    }

    private fun showSmartNotifications() {
        val alerts = arrayOf(
            "موسم الطماطم يبدأ خلال 10 أيام – حضر محصولك",
            "لا تروِ المزروعات غداً – أمطار مرتقبة بنسبة 70%",
            "انضم فلاح جديد من ولاية وهران",
            "تغير في سعر التمور: 800 دج/كلغ (الكمية: 50 كلغ)"
        )
        AlertDialog.Builder(this)
            .setTitle("إشعارات ذكية")
            .setItems(alerts, null)
            .show()
    }

    private fun showSettings() {
        val settings = arrayOf(
            "الصفحة الرئيسية",
            "اطلب منتجك",
            "إبلاغ عن مشكلة",
            "المنتدى",
            "اللغة",
            "حول التطبيق",
            "إضافة صورة",
            "تسجيل الخروج"
        )
        AlertDialog.Builder(this)
            .setTitle("الإعدادات")
            .setItems(settings) { _, i ->
                val action = when (settings[i]) {
                    "اطلب منتجك" -> "سيتم إرسال طلبك للتجار"
                    "إبلاغ عن مشكلة" -> "تم إرسال بلاغك"
                    "تسجيل الخروج" -> { finish(); "تم تسجيل الخروج" }
                    else -> "تم اختيار: ${settings[i]}"
                }
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}
