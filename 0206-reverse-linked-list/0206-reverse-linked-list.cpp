/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(!head) return nullptr;
        ListNode* move = head;
        ListNode* follow = nullptr;
        
        while(move){
            ListNode* temp = move -> next;
            move -> next = follow;
            follow = move;
            move = temp;
        }
        return follow;
    }
};