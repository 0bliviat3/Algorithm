#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>


void solve() {

    std::vector<std::vector<std::string>> digit = {
        {"0000","0  0","0  0","0  0","0000"},
        {"   1","   1","   1","   1","   1"},
        {"2222","   2","2222","2","2222"},
        {"3333","   3","3333","   3","3333"},
        {"4  4","4  4","4444","   4","   4"},
        {"5555","5","5555","   5","5555"},
        {"6666","6","6666","6  6","6666"},
        {"7777","   7","   7","   7","   7"},
        {"8888","8  8","8888","8  8","8888"},
        {"9999","9  9","9999","   9","   9"}
    };

    std::string s;
    std::cin >> s;

    for (int idx = 0; idx < s.size(); idx++) {
        int d = s[idx] - '0';

        for (int i = 0; i < 5; i++) {
            std::cout << digit[d][i];

            if (idx == s.size() - 1 && i == 4) {
                continue;
			}
            std::cout << "\n";
        }

        if (idx != s.size() - 1) {
            std::cout << "\n";
        }
    }

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}