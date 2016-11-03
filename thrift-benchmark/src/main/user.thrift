namespace java com.unionpay.serializer.thrift.dto


struct User {
    1:  i64 id;
    2:  string userName;
    3:  list<string> everUsedNames;
    4:  i32 gender;
    5:  i32 age;
    6:  i32 praiseCount;
    7:  list<i64> fanIds;
    8:  list<i64> followerIds;
    9:  list<string> fanNames;
    10: list<string> followNames;
    11: list<i64> weightIds;

    12: UserAddress userAddress;

    13: list<UserOrder> userOrder;

}

struct UserAddress {
    1:  i64 id;
    2:  string address;
    3:  string phone;
}

struct UserOrder {
    1:  i64 id;
    2:  i64 gmtCreate;
    3:  i32 money;
    4:  string location;
}