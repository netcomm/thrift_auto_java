/*
The idea of this test is that everything is structurally identical to DebugProtoTest.
If I messed up the naming of the reflection local typespecs,
then compiling this should give errors because of doubly defined symbols.
*/

namespace java test

enum TweetType {
    TWEET,       
    RETWEET = 2, 
    DM = 0xa,
    REPLY
}

const map<string,string> MAP_CONST = {"hello": "world", "goodnight": "moon"}

exception Xception {
  1: i32 errorCode,
  2: string message
}

exception Xception2 {
  1: i32 errorCode
}

struct userPosi
{
	1: string posi
}

struct UserProfile {
        1: i32 uid,
        2: required string name,
        3: string blurb,
        4: userPosi theuserPosi,
        5: optional TweetType tweetType = TweetType.TWEET
      }
      
service UserStorage {
        void store(1: UserProfile user),
        string getUserName() throws(1: Xception err1, 2: Xception2 err2),
        list<list<UserProfile>> retrieve(1: i32 uid, 2: required string test) throws(1: Xception err1)
      }