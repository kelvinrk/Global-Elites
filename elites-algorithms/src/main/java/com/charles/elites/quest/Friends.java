package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Member {
    private String email;
    private Collection<Member> friends;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return !(email != null ? !email.equals(member.email) : member.email != null);

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    public Member(String email) {
        this(email, new ArrayList<Member>());
    }

    public Member(String email, Collection<Member> friends) {
        this.email = email;
        this.friends = friends;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Member> getFriends() {
        return friends;
    }

    public void addFriends(Collection<Member> friends) {
        this.friends.addAll(friends);
    }

    public void addFriend(Member friend) {
        friends.add(friend);
    }
}

public class Friends {
    public static List<Member> getFriendsOfDegree(Member member, int degree) {
        List<Member> res = new ArrayList<>();

        Queue<Member> queue = new LinkedList<>();

        queue.offer(member);

        Set<Member> visited = new HashSet<>();

        while (degree > 0) {
            if (queue.isEmpty())
                break;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Member cur = queue.poll();
                visited.add(cur);
                Collection<Member> temp = cur.getFriends();
                for (Member m : temp) {
                    if (visited.contains(m))
                        continue;
                    visited.add(m);
                    queue.offer(m);
                }
            }
            degree--;
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        Member a = new Member("A");
        Member b = new Member("B");
        Member c = new Member("C");
        Member d = new Member("D");
        Member e = new Member("E");
        Member f = new Member("F");


        a.addFriend(b);
        a.addFriend(d);
        a.addFriend(f);
        b.addFriend(c);
        d.addFriend(e);
        f.addFriend(e);

        for (Member friend : getFriendsOfDegree(a, 2))
            System.out.println(friend.getEmail());
    }
}