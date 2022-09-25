package ir.androad.cache.daos

import androidx.room.*
import ir.androad.cache.models.CustomerPurchaseHistoryEntity
import ir.androad.cache.models.SellerCloseHoursEntity
import ir.androad.cache.models.SellerOpenHoursEntity

@Dao
interface UtilsDao {

    // Seller Open Hours
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSellerOpenHours(sellerOpenHoursEntity: SellerOpenHoursEntity)

    @Query("SELECT * FROM `Seller_Open_Hour_Table` WHERE id = :sellerOpenHoursId")
    suspend fun fetchSellerOpenHoursById(sellerOpenHoursId: Long?): SellerOpenHoursEntity

    @Update(entity = SellerOpenHoursEntity::class)
    suspend fun updateSellerOpenHours(sellerOpenHoursEntity: SellerOpenHoursEntity?)

    @Query("DELETE FROM `Seller_Open_Hour_Table`")
    suspend fun deleteSellerOpenHours()

    @Query("SELECT COUNT(*) FROM `Seller_Open_Hour_Table`")
    suspend fun isSellerOpenHoursCacheAvailable(): Int


    // Seller Close Hours
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSellerCloseHours(sellerCloseHoursEntity: SellerCloseHoursEntity)

    @Query("SELECT * FROM `Seller_Close_Hour_Table` WHERE id = :sellerCloseHoursId")
    suspend fun fetchSellerCloseHoursById(sellerCloseHoursId: Long?): SellerCloseHoursEntity

    @Update(entity = SellerCloseHoursEntity::class)
    suspend fun updateSellerCloseHours(sellerCloseHoursEntity: SellerCloseHoursEntity?)

    @Query("DELETE FROM `Seller_Close_Hour_Table`")
    suspend fun deleteSellerCloseHours()

    @Query("SELECT COUNT(*) FROM `Seller_Close_Hour_Table`")
    suspend fun isSellerCloseHoursCacheAvailable(): Int


    // Customer Purchase History
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCustomerPurchaseHistory(customerPurchaseHistoryEntity: CustomerPurchaseHistoryEntity)

    @Query("SELECT * FROM `Customer_Purchase_History_Table`")
    suspend fun fetchCustomerPurchaseHistories(): List<CustomerPurchaseHistoryEntity>?

    @Query("SELECT * FROM `Customer_Purchase_History_Table` WHERE id = :customerPurchaseHistoryId")
    suspend fun fetchCustomerPurchaseHistoryById(customerPurchaseHistoryId: Long?): CustomerPurchaseHistoryEntity

    @Query("SELECT * FROM `Customer_Purchase_History_Table` WHERE customer_id = :customerId")
    suspend fun fetchCustomerPurchaseHistoryByCustomerId(customerId: Long?): List<CustomerPurchaseHistoryEntity>

    @Query("SELECT * FROM `Customer_Purchase_History_Table` WHERE order_id = :orderId")
    suspend fun fetchCustomerPurchaseHistoryByOrderId(orderId: Long?): List<CustomerPurchaseHistoryEntity>

    @Query("SELECT COUNT(*) FROM `Customer_Purchase_History_Table`")
    suspend fun isCustomerPurchaseHistoryCacheAvailable(): Int
}