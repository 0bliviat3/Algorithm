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

    int n;
    std::cin >> n;

    int cnt = 0;
	bool flag = false;

    while (n) {
        if (n % 10 == 0) {
            if (flag) cnt++;
        }
        else {
            flag = true;
        }
		n /= 10;
    }

    std::cout << cnt;

}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}